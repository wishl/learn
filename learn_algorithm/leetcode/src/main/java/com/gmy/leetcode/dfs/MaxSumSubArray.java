package com.gmy.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数组求这个数组所有子数组中的最大值与最小值差值之和, 比如[1,3,2] 一共有6个子数组，其中每一个子数组最大值与最小值的差 如下:
 * [1] 最大值是1,最小值是1,则差值1-1=0
 * [1,3] 3 - 1 = 2
 * [1,3,2] 3 - 1 = 2
 * [3] 3 - 3 = 0
 * [3,2] 3 - 2 = 1
 * [2] 2 - 2 = 0
 * 总计 0+2+2+0+1+0 = 5
 *
 * 作者：EDCTY
 * 链接：https://leetcode.cn/circle/discuss/7DwxxK/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxSumSubArray {

    private List<List<Integer>> res = new ArrayList<>();

    public int maxSumSubArray(int[] arr) {
        List<Integer> result = new ArrayList<>();
        findSubSeq(arr, result, 0);
        int sum = 0;
        for (List<Integer> re : res) {
            sum += Math.abs(re.get(re.size() - 1) - re.get(0));
        }
        return sum;
    }


    private void findSubSeq(int[] arr, List<Integer> result, int index) {
        if (index == arr.length) {
            return;
        }
        for (int i = index; i < arr.length; i++) {
            result.add(arr[i]);
            res.add(new ArrayList<>(result));
        }
        findSubSeq(arr, new ArrayList<>(), index + 1);
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        List<Integer> res = new ArrayList<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (stack.isEmpty() || nums[i] <= stack.peek()) {
                stack.push(nums[i]);
            }
            else {
                int value = stack.peek();
                stack.pop();
                res.add(value);
            }
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        System.out.println(res);
    }

}
