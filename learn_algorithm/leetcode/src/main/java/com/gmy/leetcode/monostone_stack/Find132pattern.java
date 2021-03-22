package com.gmy.leetcode.monostone_stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeMap;

/**
 * 给你一个整数数组 nums ，数组中共有 n 个整数。
 * 132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/132-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Find132pattern {

    /**
     * -1,-2,2,3,-3,0
     * @param nums
     * @return
     */
//    public boolean find132pattern(int[] nums) {
//        int n = nums.length;
//        if (n < 3) {
//            return false;
//        }
//
//        // 左侧最小值
//        int leftMin = nums[0];
//        // 右侧所有元素
//        TreeMap<Integer, Integer> rightAll = new TreeMap<Integer, Integer>();
//
//        for (int k = 2; k < n; ++k) {
//            rightAll.put(nums[k], rightAll.getOrDefault(nums[k], 0) + 1);
//        }
//
//        for (int j = 1; j < n - 1; ++j) {
//            if (leftMin < nums[j]) {
//                Integer next = rightAll.ceilingKey(leftMin + 1);
//                if (next != null && next < nums[j]) {
//                    return true;
//                }
//            }
//            leftMin = Math.min(leftMin, nums[j]);
//            rightAll.put(nums[j + 1], rightAll.get(nums[j + 1]) - 1);
//            if (rightAll.get(nums[j + 1]) == 0) {
//                rightAll.remove(nums[j + 1]);
//            }
//        }
//
//        return false;
//    }

    public boolean find132pattern(int[] nums) {
        if(nums.length<3){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int tmp = Integer.MIN_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<tmp){
                return true;
            }
            while(!stack.isEmpty() && nums[i]>stack.peek()){
                tmp =  stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Find132pattern find132pattern = new Find132pattern();
        boolean pattern = find132pattern.find132pattern(new int[]{-2, 2, 3, -3, 0});
        System.out.println(pattern);
    }

//     while (!deque.isEmpty() && nums[deque.peek()] > nums[i]) {
//                deque.pop();
//            }
//            if (!deque.isEmpty()) {
//                return true;
//            } else {
//                deque.push(i);
//            }
}
