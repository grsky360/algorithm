package ilio.algorithm.data;

/**
 * @Author hyia
 * @Date 2020/10/12 10:49
 */
public class LinkedNodeRoot {

    public final KVNode head = new KVNode(-1, -1);
    public final KVNode tail = new KVNode(-1, -1);

    public LinkedNodeRoot() {
        head.next = tail;
        tail.prev = head;
    }

    public void add(KVNode node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    public KVNode remove(KVNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }

    @Override
    public String toString() {
        return head.toString();
    }
}
