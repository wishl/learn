package com.gmy.leetcode.doublepoint;

import java.util.Arrays;

/**
 * 给你一个字符数组 chars ，请使用下述算法压缩：
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 * 如果这一组长度为 1 ，则将字符追加到 s 中。
 * 否则，需要向 s 追加字符，后跟这一组的长度。
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。
 * 需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
 * 请在 修改完输入数组后 ，返回该数组的新长度。
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/string-compression
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Compress {

    public int compress(char[] chars) {
        int left = 0, right = 0, index = 0, length = 0;
        String s = "";
        while (right <= chars.length) {
            if (right == chars.length || chars[right] != chars[left]) {
                chars[index++] = chars[left];
                length = right - left;
                left = right;
                if (length == 1) {
                    right++;
                    continue;
                }
                s = String.valueOf(length);
                for (int i = 0; i < s.length(); i++) {
                    chars[index++] = s.charAt(i);
                }
            }
            right++;
        }
        return index;
    }

    public static void main(String[] args) {
        Compress compress = new Compress();
        char[] chars = "abbbbbbbbbbbb".toCharArray();
        int result = compress.compress(chars);
        char[] resultNums = new char[result];
        System.arraycopy(chars, 0, resultNums, 0, result);
        System.out.println(result);
        System.out.println(Arrays.toString(resultNums));

    }
}
