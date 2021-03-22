package com.gmy.leetcode;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 算法：RPC框架常见的一个功能是负载均衡，请实现一个权重随机均衡（Weighted Random）算法，注意时间复杂度和空间复杂度以及代码整洁.          func(map[string]int)string{      }
 * //map对应name和对应的权重，例如map{a:5,b:2,c:3},表示有50%概率返回a,20%概率返回b,30%概率返回c
 */
public class Test {

    /**
     *
     * @param map
     * @return
     */
    public String doTest(Map<String, Integer> map) {
        int sum = 0;
        List<Rate> rateList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sum += entry.getValue();
            rateList.add(new Rate(sum, entry.getKey()));
        }
        rateList = rateList.stream()
            .sorted(Comparator.comparingInt(Rate::getRate))
            .collect(Collectors.toCollection(ArrayList::new));
        Random random = new Random();
        int randomInt = random.nextInt(sum);
        for (int i = 0; i < rateList.size(); i++) {
            if (rateList.get(i).getRate() >= randomInt) {
                return rateList.get(i).getName();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Test test = new Test();
        Map<String, Integer> map = new HashMap<String, Integer>() {{
            put("a", 5);
            put("b", 2);
            put("c", 3);
        }};
        String result = test.doTest(map);
        System.out.println(result);
    }

    static class Rate {
        private int rate;
        private String name;

        public int getRate() {
            return rate;
        }

        public String getName() {
            return name;
        }

        public Rate(int rate, String name) {
            this.rate = rate;
            this.name = name;
        }
    }

}
