package com.gmy.leetcode;

/**
 * 小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves， 字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
 * 出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，但均需大于等于 1。每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/UlBDOe
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumOperations {

    public static int minimumOperations(String leaves) {
        char[] chars = leaves.toCharArray();
        int times = 0;
        if (chars[0] != 'r') {
            chars[0] = 'r';
            times++;
        }
        if (chars[chars.length - 1] != 'r') {
            chars[chars.length - 1] = 'r';
            times++;
        }
        leaves = new String(chars);
        // 可能不包含y
        int index = leaves.indexOf('y') == -1 ? 1 : leaves.indexOf('y');
        int lastIndex = leaves.lastIndexOf('y') == -1 ? leaves.length() - 2 : leaves.lastIndexOf('y');
        String substring = leaves.substring(index, lastIndex + 1);
        if (!substring.contains("r")) {
            return times;
        }
        if (!substring.contains("y")) {
            return times + 1;
        }
        return getMinTimes(substring, times);
    }

    private static int getMinTimes(String leaves, int times) {
        System.out.println(leaves);
        int index = leaves.indexOf("r");
        if (index == -1) {
            return times;
        }
        return Math.min(changeR(index, leaves, times), getMinTimes(leaves.substring(index + 1), ++times));
    }

    private static int changeR(int index, String leaves, int times) {
        if (leaves.length() == 0) {
            return times;
        }
        char[] chars = leaves.toCharArray();
        for (int i = index + 1; i < chars.length; i++) {
            if (chars[i] == 'y') {
                times++;
            }
        }
        return times;
    }

    public static void main(String[] args) {
//        int result = minimumOperations("yryyyyrry");
        int result = minimumOperations("ryyyrrrryrryyyyrrryrryyyryrryryyrryyyryyryyyyryrrryryyryrryyryryryrryyrryyyryrrryryryrrrryrrrrrryry");
//        int result = getMinTimes("yrrrrrry", 0);

        System.out.println(result);
    }

}
