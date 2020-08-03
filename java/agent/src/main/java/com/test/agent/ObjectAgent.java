package com.test.agent;

import com.test.agent.attach.MyTransformer;

import java.lang.instrument.Instrumentation;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ObjectAgent {

    static Instrumentation instrumentation;

    private static ScheduledExecutorService executorService =
            Executors.newSingleThreadScheduledExecutor();


    public static void premain(String agentArgs, Instrumentation instrumentation) {
        System.out.println("premain invoked");
        MyTransformer myTransformer = new MyTransformer("test");
        instrumentation.addTransformer(myTransformer);
        ObjectAgent.instrumentation = instrumentation;
        initXbean();
    }

    public static void premain(Instrumentation instrumentation) {
        System.out.println("premain invoked without param");
        ObjectAgent.instrumentation = instrumentation;
    }

    public static long getObjectSize(Object o) {
        return instrumentation.getObjectSize(o);
    }

    private static void initXbean() {
        executorService.scheduleAtFixedRate(()->{
            printMemory();
            printMemoryPool();
            printThread();
        }, 0, 1, TimeUnit.SECONDS);

    }

    // 堆内存
    private static void printMemory() {
        MemoryMXBean mxb = ManagementFactory.getMemoryMXBean();
        //Heap
        // 可用堆大小
        System.out.println("Max:" + mxb.getHeapMemoryUsage().getMax() / 1024 / 1024 + "MB");
        // 初始大小
        System.out.println("Init:" + mxb.getHeapMemoryUsage().getInit() / 1024 / 1024 + "MB");
        // 虚拟机能使用内存
        System.out.println("Committed:" + mxb.getHeapMemoryUsage().getCommitted() / 1024 / 1024 + "MB");
        // 已使用的内存
        System.out.println("Used:" + mxb.getHeapMemoryUsage().getUsed() / 1024 / 1024 + "MB");
    }

    // 虚拟机内存使用情况
    private static void printMemoryPool() {
        List<MemoryPoolMXBean> mxb = ManagementFactory.getMemoryPoolMXBeans();
        for (MemoryPoolMXBean memoryPoolMXBean : mxb) {
            System.out.println("Name:" + memoryPoolMXBean.getName());
            System.out.println("Usage:" + memoryPoolMXBean.getUsage());
            System.out.println("Manager:" + memoryPoolMXBean.getType());
            System.out.println("--------------------");
        }
    }

    private static void printThread() {
        ThreadMXBean txb = ManagementFactory.getThreadMXBean();
        System.out.println("thread count:" + txb.getThreadCount());
        for (long id : txb.getAllThreadIds()) {
            ThreadInfo threadInfo = txb.getThreadInfo(id);
            long blockedTime = threadInfo.getBlockedTime();
            System.out.println("cpu time:" + txb.getThreadCpuTime(id));
            System.out.println("user time:" + txb.getThreadUserTime(id));
            System.out.println("---------------");
        }
        System.out.println("findDeadlockedThreads:");
        if (txb.findDeadlockedThreads() != null) {
            for (long id : txb.findDeadlockedThreads()) {
                ThreadInfo threadInfo = txb.getThreadInfo(id);
                System.out.println(threadInfo.toString());
            }
        }
    }

}
