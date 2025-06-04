package com.gmy.leetcode.doublepoint;


/**
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 *
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由
 * 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。
 * 修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，
 * 下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
 *
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，
 * 只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。
 * 如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，
 * 因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/compare-version-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int max = Math.max(v1.length, v2.length);
        for (int i = 0; i < max; i++) {
            String v1String = "", v2String = "";
            if (i < v1.length) {
                v1String = v1[i];
            }
            if (i < v2.length) {
                v2String = v2[i];
            }
            int compare = compare(v1String, v2String);
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public int compare(String v1, String v2) {
        int v1Point = v1.length() - 1;
        int v2Point = v2.length() - 1;
        int compare = 0;
        while (v1Point >= 0 || v2Point >= 0) {
            int v1Char = 0, v2Char = 0;
            if (v1Point >= 0) {
                v1Char = v1.charAt(v1Point) - '0';
            }
            if (v2Point >= 0) {
                v2Char = v2.charAt(v2Point) - '0';
            }
            if (v1Char != v2Char) {
                compare = v1Char > v2Char ? 1 : -1;
            }
            v1Point--;
            v2Point--;
        }
        return compare;
    }

    public static void main(String[] args) {
        CompareVersion compareVersion = new CompareVersion();
        int compare = compareVersion.compareVersion("0.1", "1.1");
//        int compare = compareVersion.compare("000100", "99000");
        System.out.println(compare);
//        String[] s = new String[] {"0"};
//        compareVersion.delLeftZero(s);
//        System.out.println(s[0]);
    }
}
