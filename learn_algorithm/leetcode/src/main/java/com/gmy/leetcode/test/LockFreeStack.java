package com.gmy.leetcode.test;

/**
 * 基于 testAndset (CAS) 的线程安全栈，数组实现，容量 188。
 */
public class LockFreeStack {
    private static final int CAP = 188;
    private final int[] values = new int[CAP];
    private final int[] next = new int[CAP];   // 链表 next 指针
    private volatile int head = -1;             // 栈顶索引，-1 为空
    private int slot = 0;                       // 下一个可用数组位置（单线程初始化时分配，不需 CAS）

    /** 线程安全的 CAS 操作（题目提供） */
    private static boolean testAndset(int ref, int target, int before) {
        throw new UnsupportedOperationException("由平台实现");
    }

    // head 字段的地址标识，testAndset 需要传引用
    private int headRef() { return 0; } // 占位，平台会将 head 映射为引用

    public boolean push(int val) {
        if (slot >= CAP) return false;
        int idx = slot++;                   // 分配新节点
        values[idx] = val;
        int h;
        do {
            h = head;
            next[idx] = h;
        } while (!testAndset(head, idx, h));
        return true;
    }

    public Integer pop() {
        int h;
        do {
            h = head;
            if (h == -1) return null;
        } while (!testAndset(head, next[h], h));
        return values[h];
    }
}
