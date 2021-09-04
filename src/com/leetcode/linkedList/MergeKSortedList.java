package com.leetcode.linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedList {

    /**
     * LinkedList 구조에 이해
     * minHeap구조를 생각한다.
     * https://www.inflearn.com/course/%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%9E%90%EB%B0%94/lecture/22789?tab=note&speed=1.5
     */
    public static void main(String[] args) {
        MergeKSortedList a = new MergeKSortedList();

        //          L1 (1,4,5)

        // L2(1,3,4)            L3(2,6) 구조

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] list = new ListNode[3];
        list[0] = l1;
        list[1] = l2;
        list[2] = l3;
        ListNode result = a.solve(list);
        a.print(result);
    }

    private void print(ListNode node) {
        while(node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
    public ListNode solve(ListNode[] lists) {

        //1. 자바 8
//	     Queue<ListNode> queue= new PriorityQueue<>((a,b)-> a.val-b.val);

        // 2
//			Queue<ListNode> queue = new PriorityQueue<>(Comp);

        // 3
        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val -l2.val;
            }
        });


        ListNode head = new ListNode(0);
        ListNode res = head;

        //2. for while
        for (ListNode list : lists) {
            if (list != null)
                queue.offer(list);
        }

        while (!queue.isEmpty()) {
            ListNode n = queue.poll();
            System.out.println("poll " + n.val);
            res.next = n;
            res = res.next;
            if (n.next != null)
                queue.offer(n.next);
        }
        return head.next;
    }

    Comparator<ListNode> Comp = new Comparator<ListNode>() {
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    };
}
