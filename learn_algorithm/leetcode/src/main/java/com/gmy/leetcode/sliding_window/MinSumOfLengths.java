package com.gmy.leetcode.sliding_window;

import org.omg.CORBA.ARG_IN;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组arr 和一个整数值target。
 * 请你在 arr中找 两个互不重叠的子数组且它们的和都等于target。可能会有多种方案，请你返回满足要求的两个子数组长度和的 最小值 。
 * 请返回满足要求的最小长度和，如果无法找到这样的两个子数组，请返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinSumOfLengths {

    /**
     * 再看第二个问题，要如何找到两个最短的并且不重叠的子数组。
     * 最朴素的想法就是找到所有满足条件的子数组后，按照长度排序，然后贪心选择两个最短的。
     * 如果这两个子数组不重叠，那么我们就找到了最终答案。如果有重叠发生，就尝试换另外一个短的子数组。
     * 该思路理论上可行，不过要同时控制两个因素：两个子数组的长度和最短、两个子数组不重叠，实现起来比较繁琐。
     * 这里，我们重点考虑不重叠的问题，采用动态规划的思路，遍历所有可能的子数组和，找出里面和最小的。
     *
     * 由于要确保子数组不重叠，我们很自然的想到将数组分为前后两部分，
     * 每一次当我们找到一个满足条件的子数组时，假设这个子数组处于后半部分，
     * 如果能够知道这个子数组前面最短的子数组是多少，那么这两个长度相加就构成了一个可选的答案。
     * 当遍历完所有的后半部分的子数组时，可选答案中和最小的就是最终的答案。来看一个例子，考察数组arr=[4,1,1,1,4,2,1,4,3,4]，
     * target=3，令dp[i]表示子数组arr[0,i)里面满足条件的子数组的最短长度：
     *
     * 1、为方便边界处理，dp比arr长一个，dp[i+1]对应arr[i]，dp[0]初始化为一个比arr长度大的值，
     * 表示没有满足条件的子数组。在搜索过程中，如果没有找到一个满足条件的子数组，那么dp[i]保持不变，即dp[i]=dp[i-1]
     *
     * 2、首先找到子数组[1,1,1]，长度为3。该子数组右边界为index3，这意味着所有i大于3的dp[i]最大只能是3。
     * 即所有包含[1,1,1]的子数组，它的最短长度最大只能是3。另外，没有必要立即更新dp[4]~dp[10]，只需要更新dp[4]，
     * 并记录下这个最小值就可以了。于此同时，因为[1,1,1]的左边界为index1，我们得到了一个候选答案3+dp[1]=14。
     *
     * 3、然后找到子数组[2,1]，长度为2，比前一个子数组更短。该子数组右边界为index6，这意味着所有i大于6的dp[i]最大只能是2。
     * 因为[2,1]的左边界为index5，我们得到了一个候选答案2+dp[5]=5。
     *
     * 4、最后找到子数组[3]，长度为1。该子数组右边界为index8，这意味着所有i大于8的dp[i]最大只能是1。
     * 因为[3]的左边界为index8，我们得到了一个候选答案1+dp[8]=3。
     *
     * 5、最终的答案在{14,5,3}之中产生，很明显应该选3。如果所有候选答案都大于数组的长度，
     * 说明没有找到两个不重合的子数组，那就应该返回-1
     *
     * 作者：wen-rou-yi-dao-123
     * 链接：https://leetcode.cn/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/solution/xiang-xi-jiang-jie-yi-xia-shuang-zhi-zhe-jjt9/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param arr
     * @param target
     * @return
     */
    public int minSumOfLengths(int[] arr, int target) {
        int size = arr.length, left = 0, right, sum = 0, minSumOfLens = Integer.MAX_VALUE;
        int[] dp = new int[size + 1];
        dp[0] = size + 1;  // dp[i]表示区间[0,i)之间最短的和为target的子数组，先初始化为一个较大的数表示不存在。因为会做加法运算，不能初始化为INT_MAX
        for (right = 0; right < size; ++right) {
            sum += arr[right];
            while (sum > target) {
                sum -= arr[left++];
            }
            if (sum == target) {
                // 区间[left,right]是一个和为target的子数组，该子数组长度为len
                int len = right - left + 1;
                // 如果有解，我们遍历了所有的第二个子数组，同时加上它前面长度最短的第一个子数组就是答案
                minSumOfLens = Math.min(minSumOfLens, len + dp[left]);
                // 更新dp，取长度更小的一个
                dp[right + 1] = Math.min(dp[right], len);
            }
            else {
                dp[right + 1] = dp[right];  // 不是一个和为target的子数组，dp[i]保持不变
            }
        }

        return minSumOfLens > size ? -1 : minSumOfLens;  // 大于size说明没有找到两个不重叠的子数组
    }

    public static void main(String[] args) {
        MinSumOfLengths minSumOfLengths = new MinSumOfLengths();
        //  [2,1,3,3,2,3,1]
        //[8,8,8,8,3,2]
        int result = minSumOfLengths.minSumOfLengths(new int[]{2,1,3,3,2,3,1}, 6);
        System.out.println(result);
    }
}
