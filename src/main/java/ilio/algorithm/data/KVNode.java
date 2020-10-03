package ilio.algorithm.data;

/**
 * @Author hyia
 * @Date 2020/09/25 13:47
 */
public class KVNode {

    public int key;
    public int val;
    public KVNode prev;
    public KVNode next;

    public KVNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public String toString() {
        return "KVNode{" +
            "key=" + key +
            ", val=" + val +
            ", prev=" + prev +
            ", next=" + next +
            '}';
    }
}
