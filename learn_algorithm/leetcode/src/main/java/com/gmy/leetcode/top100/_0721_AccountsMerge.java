package com.gmy.leetcode.top100;

import com.gmy.leetcode.union.AccountsMerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，
 * 其余元素是 emails 表示该账户的邮箱地址。
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。
 * 请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，
 * 但其所有账户都具有相同的名称。
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是 按字符 ASCII 顺序排列 的邮箱地址。
 * 账户本身可以以 任意顺序 返回。
 */
public class _0721_AccountsMerge {


    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int[] parent = new int[accounts.size()];
        Map<String, Integer> cache = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> accountList = accounts.get(i);
            parent[i] = i;
            for (int j = 1; j < accountList.size(); j++) {
                if (!cache.containsKey(accountList.get(j))) {
                    cache.put(accountList.get(j), i);
                } else {
                    union(parent, cache.get(accountList.get(j)), i);
                }
            }
        }
        Map<Integer, List<String>> maps = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> accountList = accounts.get(i);
            int parentI = find(parent, i);
            if (!maps.containsKey(parentI)) {
                maps.put(parentI, new ArrayList<>(accountList));
            } else {
                List<String> subList = accountList.subList(1, accountList.size());
                maps.get(parentI).addAll(subList);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : maps.entrySet()) {
            List<String> value = entry.getValue();
            List<String> list = new ArrayList<>();
            list.add(value.get(0));
            list.addAll(value.subList(1, value.size()).stream().sorted().distinct().collect(Collectors.toList()));
            result.add(list);
        }
        return result;
    }

    private void union(int[] parent, int x, int y) {
        int parentX = find(parent, x);
        int parentY = find(parent, y);
        if (parentX != parentY) {
            parent[parentY] = parentX;
        }
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) {
        _0721_AccountsMerge accountsMerge = new _0721_AccountsMerge();
        // [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
        List<List<String>> lists = accountsMerge.accountsMerge(Arrays.asList(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"),
            Arrays.asList("John","johnsmith@mail.com","john00@mail.com"), Arrays.asList("Mary","mary@mail.com"),
            Arrays.asList("John","johnnybravo@mail.com")));
        System.out.println(lists);
    }

}
