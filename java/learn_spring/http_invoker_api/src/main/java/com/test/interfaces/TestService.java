package com.test.interfaces;


import com.test.models.Result;
import com.test.models.TestModel;

public interface TestService {

    public String test();

    public String testWithParam(TestModel testModel);

    public Result testWithResult();

}
