package com.gmy.leetcode.string;

import com.gmy.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，
 * 或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。
 * 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * 编码的字符串应尽可能紧凑。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/serialize-and-deserialize-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CodecReview {

    /**
     * 后序遍历在比较大小恢复
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        List<Integer> postOrder = new ArrayList<>();
        postOrder(root, postOrder);
        String str = postOrder.toString();
        return str.substring(1, str.length() - 1);
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] split = data.split(",");
        Deque<Integer> deque = new ArrayDeque<>();
        for (String s : split) {
            deque.push(Integer.parseInt(s.trim()));
        }
        return revertTree(Integer.MAX_VALUE, Integer.MIN_VALUE, deque);
    }

    /**
     * 后序遍历二叉树
     * @return
     */
    private void postOrder(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        postOrder(treeNode.left, list);
        postOrder(treeNode.right, list);
        list.add(treeNode.val);
    }

    private TreeNode revertTree(int max, int min, Deque<Integer> stack) {
        if (stack.isEmpty() || stack.peek() >= max || stack.peek() <= min) {
            return null;
        }
        Integer poll = stack.poll();
        TreeNode treeNode = new TreeNode(poll);
        TreeNode right = revertTree(max, poll, stack);
        TreeNode left = revertTree(poll, min, stack);
        treeNode.left = left;
        treeNode.right = right;
        return treeNode;
    }

    public static void main(String[] args) {
        CodecReview codec = new CodecReview();
//        TreeNode root = TreeNode.build(new Integer[]{5,3,6,2,4,null,null,1});
        TreeNode root = TreeNode.build(new Integer[]{5,3,6,2,4,null,null,1});
        String serialize = codec.serialize(root);
        TreeNode deserialize = codec.deserialize(serialize);
        System.out.println(Arrays.toString(deserialize.toArray()));
    }

}
