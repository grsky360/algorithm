package ilio.algorithm.data;

/**
 * @Author hyia
 * @Date 2020/09/25 13:47
 */
public class FrequentKVNode extends KVNode {

    public int frequent = 0;

    public FrequentKVNode(int key, int val) {
        super(key, val);
    }

    @Override
    public String toString() {
        return (prev != null ? prev + " -> " : "") +
            "{" + key + ":" + val + ":" + frequent + "}" +
            (next != null ? " -> " + next : "");
    }
}
