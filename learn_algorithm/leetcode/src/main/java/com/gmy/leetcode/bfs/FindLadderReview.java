package com.gmy.leetcode.bfs;

import java.lang.reflect.GenericDeclaration;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * review FindLadders,
 * FindLadders方法虽然可以做到，但是时间复杂度太高，可以优化为从结尾出发，生成图的时候过滤掉已访问节点，
 * 这样可以保证最短路径dfs的时候可以不判断环，并且生成的图不是完整的图。
 */
public class FindLadderReview {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return result;
        }
        Map<String, List<String>> graph = buildGraph(wordSet, beginWord, endWord);
        if (graph == null) {
            return result;
        }
        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.offer(endWord);
        dfs(result, deque, endWord, beginWord, graph);
        return result;
    }

    private Map<String, List<String>> buildGraph(Set<String> wordSet, String beginWord, String endWord) {
        Deque<String> deque = new ArrayDeque<>();
        deque.offer(beginWord);
        wordSet.remove(beginWord);
        Map<String, Integer> steps = new HashMap<>();
        Map<String, List<String>> result = new HashMap<>();
        int step = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String currentWord = deque.poll();
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] chars = currentWord.toCharArray();
                    for (char k = 'a'; k <= 'z'; k++) {
                        chars[j] = k;
                        String newWord = String.valueOf(chars);
                        // 如果这个word已经遍历过了，则判断是否变化步数相等，如果相等，则添加
                        if (steps.containsKey(newWord) && step == steps.get(newWord)) {
                            result.get(newWord).add(currentWord);
                        }
                        if (!wordSet.contains(newWord)) {
                            continue;
                        }
                        result.putIfAbsent(newWord, new ArrayList<>());
                        result.get(newWord).add(currentWord);
                        wordSet.remove(newWord);
                        steps.put(newWord, step);
                        deque.offer(newWord);
                    }
                }
                if (currentWord.equals(endWord)) {
                    System.out.println(result);
                    return result;
                }
            }
            step++;
        }
        return null;
    }

    private void dfs(List<List<String>> res, Deque<String> deque, String s, String beginWord, Map<String, List<String>> graph) {
        if (s.equals(beginWord)) {
            res.add(new ArrayList<>(deque));
            return;
        }
        List<String> strings = graph.get(s);
        for (String string : strings) {
            deque.addFirst(string);
            dfs(res, deque, string, beginWord, graph);
            deque.removeFirst();
        }
    }

    public static void main(String[] args) {
        FindLadderReview findLadders = new FindLadderReview();
        List<String> wordList = new ArrayList<String>() {{
            add("hot");
            add("cog");
            add("dot");
            add("dog");
            add("lot");
            add("log");
        }};
        List<List<String>> ladders = findLadders.findLadders("hit", "cog", wordList);
        System.out.println(ladders);
    }
}
