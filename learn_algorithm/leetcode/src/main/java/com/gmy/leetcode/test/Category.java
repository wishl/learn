package com.gmy.leetcode.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Guanmengyuan
 * @Date Created in 23:34 2026/5/12
 */
public class Category {
    int id;
    int parentId;
    String name;
    List<Category> sub = new ArrayList<>();

    Category(Integer id, Integer parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }

    // 构建树
    public static Category buildTree(Category[] nodes) {
        Map<Integer, Category> map = new HashMap<>();
        Category root = new Category(0, 0, "root");
        map.put(0, root);

        for (Category node : nodes) {
            map.put(node.id, node);
            // parent_id < id 保证父节点一定在 map 中
            map.get(node.parentId).sub.add(node);
        }
        return root;
    }
}
