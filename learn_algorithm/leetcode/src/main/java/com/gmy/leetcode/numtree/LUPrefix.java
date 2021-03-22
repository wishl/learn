package com.gmy.leetcode.numtree;

public class LUPrefix {

    private int max;
    private int[] nums;

    public LUPrefix(int n) {
        this.nums = new int[n + 1];
        this.max = 1;
    }

    public void upload(int video) {
        nums[video] = 1;
        if (video != max) {
            return;
        }
        for (int i = max; i < nums.length; i++) {
            if (nums[i] != 0) {
                max++;
            } else {
                break;
            }
        }
    }

    public int longest() {
        return max - 1;
    }

    static class ArrayTree {

        private int[] nums;

        public ArrayTree(int n) {
            this.nums = new int[n + 1];
        }

        private int lowBit(int x) {
            return x & -x;
        }

        private int sum(int index) {
            int result = 0;
            for (int i = index; i > 0; i -= lowBit(i)) {
                result += nums[i];
            }
            return result;
        }

        private void add(int index, int num) {
            for (int i = index; i < nums.length; i += lowBit(i)) {
                nums[i] += num;
            }
        }
    }

    public static void main(String[] args) {
        LUPrefix server = new LUPrefix(4);
        // 初始化 4个视频的上传流
        server.upload(3);                    // 上传视频 3 。
        System.out.println(server.longest());      // 由于视频 1 还没有被上传，最长上传前缀是 0 。
        server.upload(1);                    // 上传视频 1 。
        System.out.println(server.longest());      // 前缀 [1] 是最长上传前缀，所以我们返回 1 。
        server.upload(2);                    // 上传视频 2 。
        System.out.println(server.longest());      // 前缀 [1,2,3] 是最长上传前缀，所以我们返回 3 。
    }

}
