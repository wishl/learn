package com.gmy.leetcode.link;

public class MergeInBetween {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode first = findByIndex(list1, a - 1);
        ListNode second = findByIndex(list1, b);
        ListNode last = findLast(list2);
        first.next = list2;
        last.next = second.next;
        return list1;
    }

    private ListNode findByIndex(ListNode listNode, int index) {
        int i = 0;
        while (i < index) {
            listNode = listNode.next;
            i++;
        }
        return listNode;
    }

    private ListNode findLast(ListNode listNode) {
        ListNode head = listNode;
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0,1,2,3,4,5);
        ListNode listNode1 = new ListNode(1000000,1000001,1000002);
        MergeInBetween mergeInBetween = new MergeInBetween();
        mergeInBetween.mergeInBetween(listNode, 3, 4, listNode1);
        System.out.println(listNode);
    }

}
