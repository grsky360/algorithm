package ilio.algorithm.node;

import ilio.algorithm.data.ListNode;

/**
 * @Author hyia
 * @url https://leetcode-cn.com/problems/reverse-linked-list/
 * */
public class ReverseListNode {

    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head;
            head = head.next;
            next.next = newHead;
            newHead = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reversed = reverseList(root);
        System.out.println();
    }
}
