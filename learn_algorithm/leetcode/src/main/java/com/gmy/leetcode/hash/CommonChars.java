package com.gmy.leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonChars {

    public List<String> commonChars(String[] A) {
        Map<Character, Integer> map = new HashMap<>();
        if (A.length == 0)
            return null;
        for (Character c : A[0].toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        for (int i = 1; i < A.length; i++) {
            String str = A[i];
            Map<Character, Integer> map2 = new HashMap<>();
            for (Character c : str.toCharArray()) {
                if (map.containsKey(c)) {
                    map2.put(c, Math.min(map2.getOrDefault(c, 0) + 1, map.get(c)));
                }
            }
            map = map2;
        }
        List<String> ans = new ArrayList<>();
        for (Character c : map.keySet()) {
            int num = map.get(c);
            for (int i = 0; i < num; i++) {
                ans.add(String.valueOf(c));
            }
        }
        return ans;

    }

}
