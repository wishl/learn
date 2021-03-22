package com.gmy.leetcode.numtree;

import java.util.Arrays;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 *  来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConstructArr {

    /**
     * 计算前缀和数组 和 后缀和数组 再相乘
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }
        // 从前往后生成的前缀数组
        int[] left = new int[a.length];
        // 从后往前生成的后缀数组
        int[] right = new int[a.length];
        left[0] = 1;
        right[a.length - 1] = 1;
        int maxIndex = a.length - 1;
        for (int i = 1; i < a.length; i++) {
            int rightIndex = maxIndex - i;
            left[i] = left[i - 1] * a[i - 1];
            right[rightIndex] = right[rightIndex + 1] * a[rightIndex + 1];
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int[] result = new int[a.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new int[] {1,2,3,4,5};
        ConstructArr constructArr = new ConstructArr();
        System.out.println(Arrays.toString(constructArr.constructArr(ints)));
    }

}
