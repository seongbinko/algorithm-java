package com.leetcode.linkedList;

/**
 * ListNode (LinkedList의 근본)
 * 243
 * 562
 * 706 이 되야 함
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(2);

        ListNode node = solve(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next; // 돌고 돌고 돌고
        }

    }

    public static ListNode solve(ListNode l1, ListNode l2) {

        //1 next를 이어나갈 첫번 째 더미 데이터 0
        ListNode newHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p3 = newHead;
        int carry = 0;

        //2
        while ( p1 != null || p2 != null) {
            if(p1 != null) {
                carry += p1.val;
                p1 = p1.next;
            }
            if(p2 != null) {
                carry += p2.val;
                p2 = p2.next;
            }
            p3.next = new ListNode(carry%10);
            p3 = p3.next;
            carry /= 10;
        }
        // 마지막 끝이 10이상일 경우 체크
        if (carry == 1) {
            p3.next = new ListNode(1);
        }
        return newHead.next;
    }
}
