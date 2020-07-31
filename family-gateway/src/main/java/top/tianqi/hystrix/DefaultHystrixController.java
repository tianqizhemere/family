package top.tianqi.hystrix;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.LogUtil;
import utils.Result;
import utils.ResultStatusCode;

import java.util.Date;

/**
 * 熔断器controller
 * @author wkh
 * @Date 2020/7/1
 */
@RestController
public class DefaultHystrixController {

    /**
     * 触发熔断器
     * @return 响应请求体
     */
    @RequestMapping("/fallback")
    public Result<String> fallback(){
        LogUtil.error(new Date() + "，触发熔断");
        return new Result<>(false, 400, ResultStatusCode.BAD_REQUEST.getMsg());
    }
}