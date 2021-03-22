package com.gmy.leetcode.union;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，
 * 其余元素是 emails 表示该账户的邮箱地址。
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，
 * 它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是 按字符 ASCII 顺序排列 的邮箱地址。账户本身可以以 任意顺序 返回。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/accounts-merge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> accountIndex = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        int[] parent = new int[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            parent[i] = i;
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (!accountIndex.containsKey(email)) {
                    accountIndex.put(email, i);
                } else {
                    union(parent, accountIndex.get(email), i);
                }
            }
        }
        Map<Integer, Set<String>> maps = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            List<String> account = accounts.get(i);
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
            inner.add(accounts.get(nameIndex).get(0));
            inner.addAll(entry.getValue());
            result.add(inner);
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
        AccountsMerge accountsMerge = new AccountsMerge();
        List<List<String>> lists = accountsMerge.accountsMerge(Arrays.asList(Arrays.asList("David","David0@m.co","David1@m.co","David2@m.co"),
                Arrays.asList("David","David3@m.co","David4@m.co"), Arrays.asList("David","David4@m.co","David5@m.co"),
                Arrays.asList("David","David2@m.co","David3@m.co")));
        System.out.println(lists);
    }

}
