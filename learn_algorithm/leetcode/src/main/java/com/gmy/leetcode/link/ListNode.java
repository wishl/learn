package com.gmy.leetcode.link;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public void setNext(int val) {
        ListNode listNode = new ListNode(val);
        this.next = listNode;
    }

}
