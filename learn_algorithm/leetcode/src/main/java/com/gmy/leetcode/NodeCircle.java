package com.gmy.leetcode;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，
 * 则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NodeCircle {

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

    public static boolean hasCycle(ListNode head) {
        ListNode n1 = head;
        ListNode n2 = head;
        while (n1 != null) {
            n1 = n1.next;
            if (n1 == null) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
            if (n1 == n2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 3;
        ListNode node1 = new ListNode();
        node1.val = 2;
        ListNode node2 = new ListNode();
        node2.val = 0;
        ListNode node3 = new ListNode();
        node3.val = -4;
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        boolean result = hasCycle(node);
        System.out.println(result);
    }

}
