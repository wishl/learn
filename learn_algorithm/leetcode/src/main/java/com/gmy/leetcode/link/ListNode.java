package com.gmy.leetcode.link;

public class ListNode {

    public int val;
    public ListNode next;

    ListNode() {}

    ListNode(int val) { this.val = val; }
    
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    
    public ListNode setNext(int val) {
        ListNode listNode = new ListNode(val);
        this.next = listNode;
        return this.next;
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
