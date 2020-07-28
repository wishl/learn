package com.test.http.invoker.service.impl;

import com.test.interfaces.TestService;
import com.test.models.Result;
import com.test.models.TestModel;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String test() {
        return "success";
    }

    @Override
    public String testWithParam(TestModel testModel) {
        return "success";
    }

    @Override
    public Result testWithResult() {
        Result result = new Result();
        result.setAge(18);
        result.setGender("男");
        result.setName("gmy");
        return result;
    }
}
