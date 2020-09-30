package ilio.algorithm.node;

import ilio.algorithm.data.ListNode;

/**
 * @Author hyia
 * @url https://leetcode-cn.com/problems/merge-sorted-array/
 * */
public class MergeSortedNode {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode curr = root;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr = curr.next = l1;
                l1 = l1.next;
            } else {
                curr = curr.next = l2;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            curr = curr.next = l1;
            l1 = l1.next;
        }
        while (l2 != null) {
            curr = curr.next = l2;
            l2 = l2.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode root1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode root2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode root = mergeTwoLists(root1, root2);
        System.out.println();
    }
}
