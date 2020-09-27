package ilio.algorithm.node;

import ilio.algorithm.data.ListNode;

public class PlusListNode {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode curr = res;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int val = carry;

            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            curr = curr.next = new ListNode(val % 10);
            carry = val / 10;
        }

        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode res = addTwoNumbers(l1, l2);
        System.out.println();
    }
}
