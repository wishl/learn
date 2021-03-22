package com.gmy.leetcode.tree;

/**
 * 给出一棵二叉树，其上每个结点的值都是0或1。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * 例如，如果路径为0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数01101，也就是13。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumRootToLeafReview {

    public int sumRootToLeaf(TreeNode root) {
        return 0;
    }

    private int cal(TreeNode root, int num) {
        if (root == null) {
            return num;
        }
        num = num << 1 + root.val;
        if (root.left == null && root.right == null) {
            return num;
        }
        int left = cal(root.left, num);
        int right = cal(root.right, num);
        return left + right;
    }
}
