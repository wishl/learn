package com.gmy.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ListTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 5, 6));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(7, 8, 9));
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(list);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        doTest(lists);
    }

    public static void doTest(List<List<Integer>> elementLists) {
        Optional<List<Integer>> result = elementLists.parallelStream()
                .filter(elementList -> elementList != null && elementList.size() != 0)
                .reduce((a, b) -> {
                    a.retainAll(b);
                    return a;
                });
        System.out.println(result.orElse(new ArrayList<>()));
    }

}
