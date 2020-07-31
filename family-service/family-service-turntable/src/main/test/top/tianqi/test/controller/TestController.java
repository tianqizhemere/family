package top.tianqi.test.controller;

import top.tianqi.test.annotation.Autowired;
import top.tianqi.test.service.TestService;

/**
 * @Author wkh
 * @Date 2020/7/3 14:50
 */
public class TestController {

    @Autowired
    private TestService testService;

    public TestService getTestService() {
        return testService;
    }
}
