package com.gmy.leetcode.sliding_window;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 排序好 的数组arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * 整数 a 比整数 b 更接近 x 需要满足：
 *
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-k-closest-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 *
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 */
public class FindClosestElements {

    /**
     * 滑动窗口
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int right = 0;
        for (; right < k && right < arr.length; right++) {
            res.add(arr[right]);
        }
        while (right < arr.length) {
            if (Math.abs(res.get(0) - x) > Math.abs(arr[right] - x) || res.get(0) == arr[right]) {
                res.remove(0);
                res.add(arr[right]);
            } else {
                return res;
            }
            right++;
        }
        return res;
    }

    /**
     * 双指针 + 二分法
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int right = binarySearch(arr, x), left = right - 1;
        while (k-- > 0) {
            if (left < 0) {
                right++;
            } else if (right >= arr.length) {
                left--;
            } else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x) ) {
                left--;
            } else {
                right++;
            }
        }
        for (int i = left + 1; i < right; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    /**
     * 算出比x大的最小值
     * @param arr
     * @param x
     * @return
     */
    public int binarySearch(int[] arr, int x) {
        int high = arr.length - 1, low = 0;
        while (low < high) {
            int mid = (high + low) / 2;
            if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        FindClosestElements findClosestElements = new FindClosestElements();
        List<Integer> closestElements = findClosestElements.findClosestElements(new int[]{1, 1, 1, 9, 10, 10}, 2, 9);
        System.out.println(closestElements);
    }


}
