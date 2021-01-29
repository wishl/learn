package com.gmy.leetcode.labuladong;

import java.util.Stack;

/**
 * https://labuladong.gitbook.io/algo/gao-pin-mian-shi-xi-lie/shi-xian-ji-suan-qi
 */
public class Calculate {

    // 如果家（）需要递归 并把String放入队列中
    int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        // 记录算式中的数字
        int num = 0;
        // 记录 num 前的符号，初始化为 +
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果是数字，连续读取到 num
            if (isdigit(c))
                num = 10 * num + (c - '0');
            // 如果不是数字，就是遇到了下一个符号，
            // 之前的数字和符号就要存进栈中
            if (!isdigit(c) || i == s.length() - 1) {
                int pre;
                switch (sign) {
                    case '+':
                        stk.push(num); break;
                    case '-':
                        stk.push(-num); break;
                    case '*':
                        pre = stk.pop();
                        stk.push(pre * num);
                        break;
                    case '/':
                        pre = stk.pop();
                        stk.push(pre / num);
                        break;
                }
                // 更新符号为当前符号，数字清零
                sign = c;
                num = 0;
            }
        }
        // 将栈中所有结果求和就是答案
        int res = 0;
        while (!stk.empty()) {
            res += stk.pop();
        }
        return res;
    }

    private boolean isdigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        int result = calculate.calculate("2-(3+4+5)");
        System.out.println(result);
    }
}
