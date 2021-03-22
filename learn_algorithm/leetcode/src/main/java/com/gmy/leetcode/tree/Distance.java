package com.gmy.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个二叉树（具有根结点root），一个目标结点target，和一个整数值 K 。
 *
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Distance {

    private List<Integer> result = new ArrayList<>();
    private int K;
    private Map<Integer, TreeNode> parents = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        this.K = K;
        findParent(root);
        getResult(target, null,0);
        return result;
    }


    private void getResult(TreeNode root, TreeNode from, int length) {
        if (root == null) {
            return;
        }
        if (length == K) {
            result.add(root.val);
        }
        if (root.left != from) {
            getResult(root.left, root, length + 1);
        }
        if (root.right != from) {
            getResult(root.right, root, length + 1);
        }
        if (parents.get(root.val) != from) {
            getResult(parents.get(root.val), root, length + 1);
        }
    }

    private void findParent(TreeNode root) {
        if (root.left != null) {
            parents.put(root.left.val, root);
            findParent(root.left);
        }
        if (root.right != null) {
            parents.put(root.right.val, root);
            findParent(root.right);
        }
    }

    public static void main(String[] args) {
        Distance distance = new Distance();
        TreeNode root = TreeNode.build(new Integer[]{0, 1, null, 3, 2});
        TreeNode left = root.left.right;
        List<Integer> list = distance.distanceK(root, left, 1);
        System.out.println(list);
    }

}
