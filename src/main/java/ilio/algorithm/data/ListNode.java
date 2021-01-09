package ilio.algorithm.data;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val, int... nexts) {
        this.val = val;
        ListNode curr = this;
        for (int next : nexts) {
            curr = curr.next = new ListNode(next);
        }
    }

    @Override
    public String toString() {
        return val + " -> " + next;
    }

    public static void main(String[] args) {
        System.out.println(new ListNode(1, 2, 3, 4, 5));
    }
}
