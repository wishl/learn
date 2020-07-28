package com.test.http.invoker.controller;

import com.test.interfaces.TestService;
import com.test.models.Result;
import com.test.models.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public String doTest(){
        return testService.test();
    }

    @RequestMapping("/test1")
    public String doTest1() {
        Result result = testService.testWithResult();
        return "success";
    }

    @RequestMapping("/test2")
    public String doTest2() {
        TestModel testModel = new TestModel();
        testModel.setAge(18);
        testModel.setName("gmy");
        return testService.testWithParam(testModel);
    }

}
