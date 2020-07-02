package exception;

import com.sun.corba.se.impl.io.TypeMismatchException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import utils.ExceptionUtil;
import utils.ResultStatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.zip.DataFormatException;

/**
 * 全局异常处理
 *
 * @Author wukh
 * @Date 2020/6/28 16:30
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * http请求的方法不正确
     */
    @ResponseBody
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public String globalException(HttpRequestMethodNotSupportedException e) {
        log.info("GlobalExceptionHandler...");
        log.info("http请求的方法不正确:【\"+e.getMessage()+\"】");
        return ExceptionUtil.resultOf(ResultStatusCode.RequestMethodNotAllowed);
    }

    /**
     * 请求参数不全
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public String missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException e) {
        log.error("请求参数不全:【"+e.getMessage()+"】");
        return ExceptionUtil.resultOf(ResultStatusCode.MissingServletRequestParameter);
    }

    /**
     * 请求参数类型不正确
     */
    @ExceptionHandler(TypeMismatchException.class)
    @ResponseBody
    public String typeMismatchExceptionHandler(TypeMismatchException e) {
        log.error("请求参数类型不正确:【"+e.getMessage()+"】");
        return ExceptionUtil.resultOf(ResultStatusCode.TypeMismatchException);
    }

    /**
     * 数据格式不正确
     */
    @ExceptionHandler(DataFormatException.class)
    @ResponseBody
    public String dataFormatExceptionHandler(DataFormatException e) {
        log.error("数据格式不正确:【"+e.getMessage()+"】");
        return ExceptionUtil.resultOf(ResultStatusCode.DataFormatException);
    }

    /**
     * 处理其他异常
     */
    @ExceptionHandler
    @ResponseBody
    public String allExceptionHandler(Exception e){
        // 会记录出错的代码行等具体信息
        log.error("具体错误信息:【"+ ExceptionUtil.getErrorMessage(e)+"】");
        int count = 0; // 只打印15行的错误堆栈
        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
            log.error(stackTraceElement.toString());
            if(count++ > 13) break;
        }
        return ExceptionUtil.resultOf(ResultStatusCode.SystemException);
    }

}
