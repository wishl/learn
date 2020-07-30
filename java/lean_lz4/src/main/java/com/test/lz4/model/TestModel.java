package com.test.lz4.model;

import java.io.Serializable;

public class TestModel implements Serializable {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static TestModel createTestModel() {
        TestModel testModel = new TestModel();
        testModel.setAge(18);
        testModel.setName("gmy");
        return testModel;
    }
}
