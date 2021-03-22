package com.gmy.leetcode.union;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * review AccountsMerge
 */
public class AccountMergeReview {

    public List<List<String>> accountsMerge(List<List<String>> lists) {
        Map<String, Integer> emailAccount = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        int parent[] = new int[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            List<String> list = lists.get(i);
            parent[i] = i;
            for (int j = 1; j < list.size(); j++) {
                String email = list.get(j);
                if (!emailAccount.containsKey(email)) {
                    emailAccount.put(email, i);
                } else {
                    union(parent, emailAccount.get(email), i);
                }
            }
        }
        Map<Integer, Set<String>> maps = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            List<String> account = lists.get(i);
            int index = find(parent, i);
            if (!maps.containsKey(index)) {
                maps.put(index, new TreeSet<>(account.subList(1, account.size())));
            } else {
                maps.get(index).addAll(account.subList(1, account.size()));
            }
        }
        for (Map.Entry<Integer, Set<String>> entry : maps.entrySet()) {
            Integer nameIndex = entry.getKey();
            List<String> inner = new ArrayList<>();
            inner.add(lists.get(nameIndex).get(0));
            inner.addAll(entry.getValue());
            result.add(inner);
        }
        return result;
    }

    public void union(int[] parent, int x, int y) {
        int parentX = find(parent, x);
        int parentY = find(parent, y);
        parent[parentX] = parentY;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) {
        AccountMergeReview accountsMerge = new AccountMergeReview();
        List<List<String>> lists = accountsMerge.accountsMerge(
                Arrays.asList(Arrays.asList("David","David0@m.co","David1@m.co","David2@m.co"),
                Arrays.asList("David","David3@m.co","David4@m.co"), Arrays.asList("David","David4@m.co","David5@m.co"),
                Arrays.asList("David","David2@m.co","David3@m.co")));
        System.out.println(lists);
    }
}
