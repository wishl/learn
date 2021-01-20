package com.gmy.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
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

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        this.K = K;
        getResult(root, target, 0);
        return result;
    }


    private Integer getResult(TreeNode root, TreeNode target, int length) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            addResult(root, 0);
            return 1;
        }
        int left = getResult(root.left, target, length + 1);
        // 再左节点找到，查询父节点的右子树
        if (left == 1) {
            K--;
            addResult(root.right, length + 1);
            return left;
        }
        int right = getResult(root.right, target, length + 1);
        if (right == 1) {
            K--;
            addResult(root.left, length + 1);
            return right;
        }
        return -1;
    }

    private void addResult(TreeNode root, int length) {
        if (root == null) {
            return;
        }
        if (K == length) {
            result.add(root.val);
        }
        addResult(root.left, length++);
        addResult(root.right, length++);
    }

    public static void main(String[] args) {
        Distance distance = new Distance();
        TreeNode root = TreeNode.build(new Integer[]{0, 1, null, 3, 2});
        TreeNode left = root.left.right;
        List<Integer> list = distance.distanceK(root, left, 1);
        System.out.println(list);
    }

}
