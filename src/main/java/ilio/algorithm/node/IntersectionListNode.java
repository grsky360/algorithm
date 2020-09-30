package ilio.algorithm.node;

import ilio.algorithm.data.ListNode;

/**
 * @Author Hyia
 * @url https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * */
public class IntersectionListNode {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a != null ? a.next : headB;
            b = b != null ? b.next : headA;
        }
        return a;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(4, new ListNode(1, new ListNode(8, new ListNode(4, new ListNode(5)))));
        ListNode head2 = new ListNode(5, new ListNode(0, new ListNode(1, head1.next.next)));
        ListNode node = getIntersectionNode(head1, head2);
        System.out.println();
    }
}
