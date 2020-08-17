package top.tianqi.family.test.controller;

import top.tianqi.family.test.annotation.Autowired;
import top.tianqi.family.test.service.TestService;

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
