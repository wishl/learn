package com.gmy.leetcode.link;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseKGroupReview {

    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode hair = new ListNode(0, head);
        ListNode pre = hair, tmp = hair;
        while (tmp.next != null) {
            tmp = tmp.next;
            n++;
            if (n % k == 0) {
                ListNode next = tmp.next;
                tmp.next = null;
                ListNode node = pre.next;
                ListNode revert = revert(node, null);
                pre.next = revert;
                pre = node;
                tmp = pre;
                node.next = next;
            }
        }
        return hair.next;
    }

    private ListNode revert(ListNode node, ListNode pre) {
        if (node == null) {
            return pre;
        }
        ListNode head = revert(node.next, node);
        node.next = pre;
        return head;
    }


    public static void main(String[] args) {
        ReverseKGroupReview reverseKGroupReview = new ReverseKGroupReview();
        ListNode build = ListNode.build(new int[]{1, 2, 3, 4});
//        ListNode revert = reverseKGroupReview.revert(build.next, build);
        ListNode revert = reverseKGroupReview.reverseKGroup(build, 3);
        System.out.println(revert);
    }
}
