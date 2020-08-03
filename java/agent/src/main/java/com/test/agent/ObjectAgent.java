package com.test.agent;

import com.test.agent.attach.MyTransformer;

import java.lang.instrument.Instrumentation;

public class ObjectAgent {

    static Instrumentation instrumentation;

    public static void premain(String agentArgs, Instrumentation instrumentation) {
        System.out.println("premain invoked");
        MyTransformer myTransformer = new MyTransformer("test");
        instrumentation.addTransformer(myTransformer);
        ObjectAgent.instrumentation = instrumentation;
    }

    public static void premain(Instrumentation instrumentation) {
        System.out.println("premain invoked without param");
        ObjectAgent.instrumentation = instrumentation;
    }

    public static long getObjectSize(Object o) {
        return instrumentation.getObjectSize(o);
    }

}
