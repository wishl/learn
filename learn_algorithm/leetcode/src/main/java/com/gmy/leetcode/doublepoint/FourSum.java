package com.gmy.leetcode.doublepoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]
 * （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d< n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        for (int left = 0; left < length - 1; left++) {
            if (left > 0 && nums[left] == nums[left - 1]) {
                continue;
            }
            for (int i = left + 1; i < length; i++) {
                int right = i;
                if (right > left + 1 && nums[right] == nums[right - 1]) {
                    continue;
                }
                long mTarget = (long) (target - nums[left]) - nums[right];
                int mLeft = right + 1, mRight = length - 1;
                while (mLeft < mRight) {
                    if (mLeft > right + 1 && nums[mLeft] == nums[mLeft - 1]) {
                        mLeft++;
                        continue;
                    }
                    if (mRight < length - 1 && nums[mRight] == nums[mRight + 1]) {
                        mRight--;
                        continue;
                    }
                    if (mTarget == (nums[mRight] + nums[mLeft])) {
                        result.add(Arrays.asList(nums[left], nums[right], nums[mLeft], nums[mRight]));
                        mLeft++;
                        mRight--;
                    } else if ((nums[mRight] + nums[mLeft]) > mTarget) {
                        mRight--;
                    } else {
                        mLeft++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        // [-3,-1,0,2,4,5]
        // [-3,-1,0,2,4,5]
        //0
        // [1,0,-1,0,-2,2]
        //0
        // [1000000000,1000000000,1000000000,1000000000]
        //-294967296
        List<List<Integer>> result = fourSum.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296);
        System.out.println(result);
    }
}
