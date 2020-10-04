package ilio.algorithm.node;

import ilio.algorithm.data.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author hyia
 * @Date 2020/10/04 17:35
 * @url https://leetcode-cn.com/problems/add-two-numbers-ii/
 */
public class PlusListNode2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> deque1 = new LinkedList<>();
        Deque<ListNode> deque2 = new LinkedList<>();
        while (l1 != null) {
            deque1.offerFirst(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            deque2.offerFirst(l2);
            l2 = l2.next;
        }
        ListNode res = null;
        int carry = 0;
        while (!deque1.isEmpty() || !deque2.isEmpty() || carry != 0) {
            int num = carry;
            if (!deque1.isEmpty()) {
                num += deque1.removeFirst().val;
            }
            if (!deque2.isEmpty()) {
                num += deque2.removeFirst().val;
            }
            res = concat(new ListNode(num % 10), res);
            carry = num / 10;
        }
        return res;
    }

    private static ListNode concat(ListNode head, ListNode node) {
        head.next = node;
        return head;
    }

    public static void main(String[] args) {
        System.out.println(addTwoNumbers(new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3)))), new ListNode(5, new ListNode(6, new ListNode(4)))));
    }
}
