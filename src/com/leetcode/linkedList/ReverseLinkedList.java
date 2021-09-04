package com.leetcode.linkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        printNode(l1);
        ListNode head = reverseList(l1);
        printNode(head);
    }
    public static ListNode reverseList(ListNode current) {

        //1. ds
        ListNode prev = null;
        ListNode next = null;

        //2. for while
        while(current !=null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }



    public static void printNode(ListNode head) {
        System.out.println("printNOde: ");
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println();
    }
}
