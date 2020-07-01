package top.tianqi.hystrix;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.LogUtil;
import utils.Result;
import utils.ResultStatusCode;

/**
 * 熔断器controller
 * @author wkh
 * @Date 2020/7/1
 */
@RestController
public class DefaultHystrixController {
    @RequestMapping("/fallback")
    public Result<Object> fallback(){
        LogUtil.error("触发熔断......");
        return new Result(false, 400, ResultStatusCode.BAD_REQUEST.getMsg());
    }
}