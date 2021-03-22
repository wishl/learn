package com.gmy.leetcode.sliding_window;

/**
 * 给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中 「优美子数组」 的数目。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-number-of-nice-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 *
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 *
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 *
 */
public class NumberOfSubarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        int odd = 0, ans = 0;
        cnt[0] = 1;
        for (int i = 0; i < n; ++i) {
            odd += nums[i] & 1;
            ans += odd >= k ? cnt[odd - k] : 0;
            cnt[odd] += 1;
        }
        return ans;
    }

    public int numberOfSubarrays1(int[] nums, int k) {
        int left = 0, right = 0, count = 0;
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        // 计算前面有多少个不为奇数的数字
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] % 2 == 1) {
                prefix[i + 1] = 0;
            } else {
                prefix[i + 1] = prefix[i] + 1;
            }
        }
        // 计算有多少个连续不为奇数的后缀
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] % 2 == 1) {
                suffix[i - 1] = 0;
            } else {
                suffix[i - 1] = suffix[i] + 1;
            }
        }
        while (right < nums.length) {
            if (nums[right] % 2 == 1) {
                k--;
            }
            while (k == 0) {
                if (nums[left] % 2 == 1) {
                    count += (prefix[left] + 1) * (suffix[right] + 1);
                    k++;
                }
                left++;
            }
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfSubarrays numberOfSubarrays = new NumberOfSubarrays();
        int[] nums = new int[] {2,2,2,1,2,2,1,1,2,2,2};
        int result = numberOfSubarrays.numberOfSubarrays(nums, 2);
        System.out.println(result);
    }

}
