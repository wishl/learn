package com.gmy.leetcode.numtree;

/**
 * 给你一份工作时间表hours，上面记录着某一位员工每天的工作小时数。
 * 我们认为当员工一天中的工作小时数大于8 小时的时候，那么这一天就是「劳累的一天」。
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * 请你返回「表现良好时间段」的最大长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-well-performing-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestWPI {

    public int longestWPI(int[] hours) {
        Tree tree = new Tree(hours);
        return tree.max;
    }

    static class Tree {

        private int[] nums;
        private int max;

        public Tree(int[] hours) {
            this.nums = new int[hours.length + 1];
            int left = 1;
            for (int i = 1; i < nums.length; i++) {
                if (hours[i - 1] > 8) {
                    add(i, 1);
                } else {
                    add(i, -1);
                }
                int sum = sum(left, i);
                if (sum <= 0) {
                    left = i + 1;
                } else {
                    max = Math.max(max, i - left + 1);
                }
            }
        }

//        public Tree1(int[] hours) {
//            this.nums = new int[hours.length + 1];
//            for (int i = 1; i < nums.length; i++) {
//                add(i, hours[i - 1]);
//            }
//        }

        public void add(int index, int value) {
            for (int i = index; i < nums.length; i += lowBit(i)) {
                nums[i] += value;
            }
        }

        public int sum(int left, int right) {
            int result = 0;
            for (int i = right; i > 0; i -= lowBit(i)) {
                result += nums[i];
            }
            for (int i = left - 1; i > 0 ; i -= lowBit(i)) {
                result -= nums[i];
            }
            return result;
        }

        private int lowBit(int index) {
            return index & -index;
        }

    }

    public static void main(String[] args) {
        LongestWPI longestWPI = new LongestWPI();
        int result = longestWPI.longestWPI(new int[]{6, 9, 9});
        System.out.println(result);
    }

}
