package com.gmy.leetcode.link;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) { this.val = val; }
    
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode(int... val) {
        ListNode build = build(val);
        this.val = build.val;
        this.next = build.next;
    }
    
    public ListNode setNext(int val) {
        ListNode listNode = new ListNode(val);
        this.next = listNode;
        return this.next;
    }

    public static ListNode build(int[] arr) {
        if (arr == null) {
            return null;
        }
        ListNode listNodes = new ListNode(arr[0]);
        ListNode head = listNodes;
        for (int i = 1; i < arr.length; i++) {
            listNodes.setNext(arr[i]);
            listNodes = listNodes.next;
        }
        return head;
    }

    @Override
    public String toString() {
        String result =  "{" +
                "\"val\":" + val;
        if (next != null) {
            result += ", \"next\":" + next.toString();
        }
        result += "}";
        return result;
    }
}
