package top.tianqi.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import top.tianqi.jwt.JwtUtil;
import top.tianqi.tools.utils.Result;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 添加了 JwtCheck的注解
 * @Author wkh
 * @Date 2020/8/10 16:54
 */
@Component
public class JwtCheckAop {

    private static final Logger log = LoggerFactory.getLogger(JwtCheckAop.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Pointcut("@annotation(top.tianqi.annotation.JwtCheck)")
    private void apiAop(){

    }

    /**
     * 方法执行前后得aop
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("apiAop()")
    public Object aroundApi(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        //获取参数上得所有注解
        Annotation[][] parameterAnnotationArray = method.getParameterAnnotations();
        Object[] args = point.getArgs();

        String token = null;

        /*
            a -> start
            这个代码片得逻辑:找出有 @RequestHeader("Authorization") 的参数，赋值给 token变量
         */
        for(Annotation[]  annotations : parameterAnnotationArray){
            for(Annotation a:annotations){
                if(a instanceof RequestHeader){
                    RequestHeader requestHeader =  (RequestHeader)a;
                    if("Authorization".equals(requestHeader.value())){
                        token = (String) args[ArrayUtils.indexOf(parameterAnnotationArray,annotations)];
                    }
                }
            }
        }
        /*
            a -> end
         */

        if(StringUtils.isBlank(token)){
            //没有token
            return authErro("请登陆");
        }else{
            //有token
            try {
                JwtUtil.checkToken(token,objectMapper);
                Object proceed = point.proceed();
                return proceed;
            }catch (ExpiredJwtException e){
                log.error(e.getMessage(),e);
                if(e.getMessage().contains("Allowed clock skew")){
                    return authErro("认证过期");
                }else{
                    return authErro("认证失败");
                }
            }catch (Exception e) {
                log.error(e.getMessage(),e);
                return authErro("认证失败");
            }
        }
    }

    /**
     * 认证错误输出
     * @param mess 错误信息
     * @return
     */
    private Object authErro(String mess) {
        Result result = new Result(HttpStatus.UNAUTHORIZED.value(), mess, null);
        return result;
    }
}
