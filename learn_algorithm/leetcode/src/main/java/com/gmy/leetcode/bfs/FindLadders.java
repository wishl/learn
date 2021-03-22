package com.gmy.leetcode.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，一个表示此过程的 转换序列 是形式上像
 * beginWord -> s1 -> s2 -> ... -> sk 这样的单词序列，并满足：
 *
 * 每对相邻的单词之间仅有单个字母不同。
 * 转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单词。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。请你找出并返回所有从 beginWord 到 endWord 的 最短转换序列 ，
 * 如果不存在这样的转换序列，返回一个空列表。每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLadders {

    private List<List<String>> res;

    /**
     * 1.先生成无向图
     * 2.遍历图找到最终结果
     * 3.遍历时注意是否有环
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.res = new ArrayList<>();
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return res;
        }
        if (!set.contains(beginWord)) {
            wordList.add(beginWord);
        }
        Map<String, List<String>> graph = buildGraph(wordList);
        Deque<String> deque = new ArrayDeque<>();
        deque.offer(beginWord);
        dfs(graph, beginWord, endWord, deque, new HashSet<>());
        return res;
    }

    private void dfs(Map<String, List<String>> graph, String begin, String end, Deque<String> deque, Set<String> used) {
        if (begin.equals(end)) {
            if (res.size() == 0 || deque.size() < res.get(0).size()) {
                this.res.clear();
                this.res.add(new ArrayList<>(deque));
                return;
            }
            if (deque.size() == res.get(0).size()) {
                this.res.add(new ArrayList<>(deque));
                return;
            }
            return;
        }
        List<String> strings = graph.get(begin);
        if (strings == null) {
            return;
        }
        for (String string : strings) {
            if (used.contains(string)) {
                continue;
            }
            deque.offer(string);
            used.add(string);
            dfs(graph, string, end, deque, used);
            deque.removeLast();
            used.remove(string);
        }
    }


    private Map<String, List<String>> buildGraph(List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();
        for (String s : wordList) {
            List<String> list = new ArrayList<>();
            for (String s1 : wordList) {
                int diff = 0;
                // 字符串长度最多不超过1
                if (s1.length() != s.length() && Math.abs(s1.length() - s.length()) > 1) {
                    continue;
                }
                if (s1.length() != s.length()) {
                    diff++;
                }
                int i = 0;
                for (; i < s1.length() && i < s.length(); i++) {
                    if (s1.charAt(i) != s.charAt(i)) {
                        diff++;
                    }
                }
                if (diff == 1) {
                    list.add(s1);
                }
            }
            graph.put(s, list);
        }
        System.out.println(graph);
        return graph;
    }

    public static void main(String[] args) {
        FindLadders findLadders = new FindLadders();
        List<String> wordList = new ArrayList<String>() {{
            add("hot");
            add("dot");
            add("dog");
            add("lot");
            add("log");
            add("cog");
        }};
        List<List<String>> ladders = findLadders.findLadders("hit", "cog", wordList);
        System.out.println(ladders);
//        findLadders.buildGraph(wordList);
    }
}
