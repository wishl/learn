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
public class SumRootToLeaf {

    public int sumRootToLeaf(TreeNode root) {
        int cal = cal1(root, 0);
        return cal;
    }

    private int getMax(int count, TreeNode treeNode) {
        if (treeNode == null) {
            return count;
        }
        int left = getMax(count + 1, treeNode.left);
        int right = getMax(count + 1, treeNode.right);
        return Math.max(left, right);
    }

    private int cal(TreeNode treeNode, int num) {
        int result = 0;
        num = ((num << 1) + treeNode.val);
        if (treeNode.left != null) {
            result += cal(treeNode.left, num);
        }
        if (treeNode.right != null) {
            result += cal(treeNode.right, num);
        }
        return result == 0 ? num : result;
    }

    private int cal1(TreeNode treeNode, int num) {
        if (treeNode == null) {
            return 0;
        }
        num = ((num << 1) + treeNode.val);
        if (treeNode.left == null && treeNode.right == null) {
            return num;
        }
        int left = cal(treeNode.left, num);
        int right = cal(treeNode.right, num);
        return left + right;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.build(new Integer[] {1,0,1,0,null,0,1});
        SumRootToLeaf sumRootToLeaf = new SumRootToLeaf();
        int result = sumRootToLeaf.sumRootToLeaf(treeNode);
        System.out.println(result);
    }

}
