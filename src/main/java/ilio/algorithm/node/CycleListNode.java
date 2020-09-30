package ilio.algorithm.node;

import ilio.algorithm.data.ListNode;

/**
 * @Author Hyia
 * @url https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * */
public class CycleListNode {

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1, new ListNode(2));
        root.next.next = root;
        ListNode enterNode = detectCycle(root);
        System.out.println();
    }
}
