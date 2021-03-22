package com.gmy.leetcode.review.window;

import java.util.HashMap;
import java.util.Map;

/**
 * 如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
 * 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。
 *
 * https://leetcode.cn/problems/swap-for-longest-repeated-character-substring/description/
 */
public class MaxRepOpt1 {

    /**
     * 给定一个字符串，你需要选择两个字符进行交换，这个操作最多进行一次，要求使得仅包含相同字符的子串尽可能的长。例如
     * ‘‘bbababaaaa"``bbababaaaa"‘‘bbababaaaa"，可以交换第 222（下标从 000 开始）
     * 个字符 aaa 与第 555 个字符 bbb，使得包含相同字符的子串最长为 666，即 ‘‘aaaaaa"``aaaaaa"‘‘aaaaaa"。
     *
     * 我们设 nnn 为字符串 text\textit{text}text 的长度，下标从 000 开始，现在有一段区间 [i,j)[i, j)[i,j)
     * （不包括 jjj ）由相同字符 aaa 构成，并且该区间两边不存在相同的字符 aaa，而整个 text\textit{text}text 中 aaa 的出现次数为
     * count[a]\textit{count}[a]count[a]，那么当 count[a]>j−i\textit{count}[a] \gt j - icount[a]>j−i ，
     * 并且 i>0i > 0i>0 或者 j<nj \lt nj<n 时，可以将其他地方出现的 aaa 与 text[i−1]\textit{text}[i-1]text[i−1]
     * 或 text[j]\textit{text}[j]text[j] 交换，从而得到更长的一段仅包含字符 aaa 的子串。
     *
     * 交换后，交换过来的 aaa 可能会使得两段连续的 aaa 拼接在一起，我们假设 [i,j)[i, j)[i,j) 是前面的一段，
     * 当 text[j+1]=a\textit{text}[j+1] = atext[j+1]=a 时，我们在找到后面的一段 [j+1,k)[j + 1, k)[j+1,k)，
     * 这两段拼接在一起构成更长的子串。
     * 注意，我们需要重新判断是否有多余的 aaa 交换到中间来，因此将拼接后的长度 k−ik - ik−i
     * 与 count[a]\textit{count}[a]count[a] 取最小值来更新答案。
     *
     * 在实现过程中，我们可以使用滑动窗口算法来求解由相同字符构成的最长区间。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/swap-for-longest-repeated-character-substring/solutions/2292109/dan-zi-fu-zhong-fu-zi-chuan-de-zui-da-ch-9ywr/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param text
     * @return
     */
    public int maxRepOpt1(String text) {
        Map<Character, Integer> count = new HashMap<Character, Integer>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        int res = 0;
        for (int i = 0; i < text.length(); ) {
            // step1: 找出当前连续的一段 [i, j)
            int j = i;
            while (j < text.length() && text.charAt(j) == text.charAt(i)) {
                j++;
            }
            int curCnt = j - i;

            // step2: 如果这一段长度小于该字符出现的总数，并且前面或后面有空位，则使用 curCnt + 1 更新答案
            if (curCnt < count.getOrDefault(text.charAt(i), 0) && (j < text.length() || i > 0)) {
                res = Math.max(res, curCnt + 1);
            }

            // step3: 找到这一段后面与之相隔一个不同字符的另一段 [j + 1, k)，如果不存在则 k = j + 1
            int k = j + 1;
            while (k < text.length() && text.charAt(k) == text.charAt(i)) {
                k++;
            }
            res = Math.max(res, Math.min(k - i, count.getOrDefault(text.charAt(i), 0)));
            i = j;
        }
        return res;
    }

}
