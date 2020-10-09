package com.gmy.leetcode;

/**
 * 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。
 * 有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NodeCircleStart {


    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
        ListNode() {
        }
    }

    /**
     *  s1 = 慢指针走的距离
     *  s2 = 快指针走的距离
     *  X = 相遇点
     *  Y = 起点到X的距离
     *  R = 环的长度
     *
     *  S1 = X + Y + NR；
     *  S2 = 2S1 = X + Y + MR;
     *  我们不关注具体走了几圈所以令M-N = N1
     *  Y = N1R - X
     *  说明N1R + Y = X所以只需要再走Y的距离就会快指针就正好走到了环的起始点。
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode node1 = head;
        ListNode node2 = head;
        // 先相遇
        while (node1 != null) {
            node1 = node1.next;
            if (node1 == null) {
                return null;
            }
            node1 = node1.next;
            node2 = node2.next;
            if (node1 == node2) {
                break;
            }
        }
        if (node1 == null) {
            return null;
        }
        // 然后多走一圈
        while (node1 != head) {
            node1 = node1.next;
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 3;
        ListNode node1 = new ListNode();
        node1.val = 2;
//        ListNode node2 = new ListNode();
//        node2.val = 0;
//        ListNode node3 = new ListNode();
//        node3.val = -4;
        node.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node1;
        ListNode result = detectCycle(node);
        System.out.println(result);
    }

}
