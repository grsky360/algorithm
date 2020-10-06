package ilio.algorithm.node;

import ilio.algorithm.data.ListNode;

/**
 * @Author hyia
 * @Date 2020/10/06 21:24
 */
public class Palindrome {

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode newHead = null;
        while (fast != null && fast.next != null) {
            ListNode next = slow;
            slow = slow.next;
            fast = fast.next.next;

            next.next = newHead;
            newHead = next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null || newHead != null) {
            if (slow == null || newHead == null || slow.val != newHead.val) {
                return false;
            }
            slow = slow.next;
            newHead = newHead.next;
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome(new ListNode(1, new ListNode(2))));
//        System.out.println(isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));
        System.out.println(isPalindrome(new ListNode(1, new ListNode(0, new ListNode(1)))));
    }
}
