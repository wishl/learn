package com.gmy.leetcode.string;

import com.gmy.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

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
public class Codec {

    private static final String COMM = "|";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        // 先层序遍历一个树
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        // 然后拼接字符串
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.val != Integer.MIN_VALUE) {
                sb.append(poll.val);
            }
            sb.append(COMM);
            if (poll.val == Integer.MIN_VALUE) {
                continue;
            }
            if (poll.left != null) {
                queue.offer(poll.left);
            } else {
                queue.offer(new TreeNode(Integer.MIN_VALUE));
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            } else {
                queue.offer(new TreeNode(Integer.MIN_VALUE));
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int startIndex = 0;
        int endIndex = 0;
        List<Integer> list = new ArrayList<>();
        while (data.length() > 0) {
            endIndex = data.indexOf(COMM);
            String substring = data.substring(startIndex, endIndex);
            data = data.substring(endIndex + 1);
            if (substring.length() == 0) {
                list.add(null);
            } else {
                list.add(Integer.parseInt(substring));
            }
        }
        return build(list);
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
//        TreeNode root = TreeNode.build(new Integer[]{5,3,6,2,4,null,null,1});
        TreeNode root = TreeNode.build(new Integer[]{5,3,6,2,4,null,null,1});
        String serialize = codec.serialize(root);
        TreeNode deserialize = codec.deserialize(serialize);
        System.out.println(Arrays.toString(deserialize.toArray()));
    }

    public TreeNode build(List<Integer> is) {
        if (is == null || is.size() == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedBlockingDeque<>();
        TreeNode root = new TreeNode(is.get(0));
        queue.offer(root);
        for (int i = 0; i < is.size(); i++) {
            TreeNode poll = queue.poll();
            for (int j = 2 * i + 1; j < 2 * i + 3 && j < is.size(); j++) {
                Integer num = is.get(j);
                if (num == null) {
                    continue;
                }
                TreeNode node = new TreeNode(num);
                queue.offer(node);
                if (j == 2 * i + 1 ) {
                    poll.left = node;
                } else {
                    poll.right = node;
                }
            }

        }
        return root;
    }

}
