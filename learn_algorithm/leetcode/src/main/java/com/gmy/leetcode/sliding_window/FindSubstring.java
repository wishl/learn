package com.gmy.leetcode.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 给定一个字符串s和一个字符串数组words。words中所有字符串 长度相同。
 *
 * s中的 串联子串 是指一个包含words中所有字符串以任意顺序排列连接起来的子串。
 *
 * 例如，如果words = ["ab","cd","ef"]， 那么"abcdef"，"abefcd"，"cdabef"，"cdefab"，
 * "efabcd"， 和"efcdab" 都是串联子串。"acdbef" 不是串联子串，因为他不是任何words排列的连接。
 * 返回所有串联字串在s中的开始索引。你可以以 任意顺序 返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindSubstring {

    /**
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Tire tire = new Tire();
        for (String word : words) {
            tire.insert(word);
        }
        Map<String, Long> countMap =
                Arrays.stream(words).collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        Map<String, Long> map = new HashMap<>();
        int left = 0, right = 0, middle = 0;
        Tire t = tire;
        String suf = null;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            t = t.get(c);
            if (t == null) {
                if (suf == null) {
                    map = new HashMap<>();
                    left = right;
                } else {
                    suf = null;
                    right--;
                }
                t = tire;
                middle = right;
            } else if (t.end) {
                resetMap(suf, map);
                suf = s.substring(middle, right);
                if ("word".equals(suf)) {
                    System.out.println(111);
                }
                int handle = handleEnd(suf, map, countMap);
                if (handle == 0) {
                    result.add(left);
                } else if (handle == -1) {
                    map = new HashMap<>();
                    left = middle;
                    right = middle;
                    suf = null;
                    t = tire;
                }
            }
        }
        return result;
    }

    private Integer handleEnd(String word, Map<String, Long> map, Map<String, Long> countMap) {
        if (countMap.get(word) == null || countMap.get(word) <= map.getOrDefault(word, 0L)) {
            return -1;
        }
        map.put(word, map.getOrDefault(word, 0L) + 1);
        List<String> keys = countMap.entrySet().stream()
                .filter(entry -> map.get(entry.getKey()) != null && map.get(entry.getKey()) == entry.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return keys.size() == countMap.size() ? 0 : 1;
    }

    private void resetMap(String word, Map<String, Long> map) {
        if (word != null) {
            map.put(word, map.get(word) - 1);
        }
    }

    static class Tire {
        private Tire[] tires = new Tire[26];
        private boolean end;

        public void insert(String word) {
            int length = word.length();
            Tire tire = this;
            for (int i = 0; i < length; i++) {
                char c = word.charAt(i);
                if (tire.tires[c - 'a'] == null) {
                    tire.tires[c - 'a'] = new Tire();
                }
                tire = tire.tires[c - 'a'];
            }
            tire.end = true;
        }

        /**
         * 是否全包含
         * @return
         */
        public boolean search(String word) {
            Tire tire = get(word);
            return tire != null && tire.end;
        }

        /**
         * 当前词是否是某个词的前缀
         * @param word
         * @return
         */
        public boolean isPrefix(String word) {
            Tire tire = get(word);
            return tire != null;
        }

        public Tire get(String word) {
            Tire tire = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (tire.tires[c - 'a'] == null) {
                    return null;
                }
                tire = tire.tires[c - 'a'];
            }
            return tire;
        }

        public Tire get(char c) {
            return tires[c - 'a'];
        }
    }

    public static void main(String[] args) {
        FindSubstring findSubstring = new FindSubstring();
        List<Integer> result = findSubstring.findSubstring("wordgoodgoodbestwordgoodbestword", new String[]{"word","good","best","word"});
        System.out.println(result);
    }

}
