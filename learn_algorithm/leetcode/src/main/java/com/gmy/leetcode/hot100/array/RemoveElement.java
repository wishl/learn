package com.gmy.leetcode.hot100.array;

public class RemoveElement {

    /**
     * 快慢指针解法
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left++] = nums[right];
            }
        }
        return left;
    }

    /**
     * 双指针解法
     * @param nums
     * @param val
     * @return
     */
    public int removeElement1(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right--];
            } else {
                left++;
            }
        }
        return left;
    }



    public static void main(String[] args) {
        int[] arr = new int[] {3,2,2,3};
        RemoveElement removeElement = new RemoveElement();
        int i = removeElement.removeElement1(arr, 3);
    }

}
