package ilio.algorithm.node;

import ilio.algorithm.data.ListNode;

/**
 * @Author hyia
 * @Date 2020/10/03 14:42
 * @url https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseKGroup {

    public static ListNode reverseKGroup(ListNode root, int k) {
        ListNode origin = new ListNode(-1);
        origin.next = root;
        ListNode left = origin;
        ListNode right = origin;
        while (right.next != null) {
            for (int i = 0; i < k && right != null; i++) {
                right = right.next;
            }
            if (right == null) {
                break;
            }
            ListNode currHead = left.next;
            ListNode currTail = right.next;
            right.next = null;
            left.next = reverse(currHead);
            currHead.next = currTail;

            left = currHead;
            right = left;
        }
        return origin.next;
    }

    private static ListNode reverse(ListNode head) {
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
        ListNode res = reverseKGroup(root, 3);
        System.out.println();
    }
}
