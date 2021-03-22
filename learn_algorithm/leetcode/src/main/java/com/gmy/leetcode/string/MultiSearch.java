package com.gmy.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个较长字符串big和一个包含较短字符串的数组smalls，
 * 设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。
 * 输出smalls中的字符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multi-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MultiSearch {

    public int[][] multiSearch(String big, String[] smalls) {
        return null;
    }

    class Trie {

        private Trie[] child;
        private List<Integer> index;

        public Trie() {
            this.child = new Trie[26];
            this.index = new ArrayList<>();
        }

        public void insert(String word) {

        }

    }

}
