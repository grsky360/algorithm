package ilio.algorithm.other;

import ilio.algorithm.data.KVNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hyia
 * @Date 2020/09/25 13:09
 * @url https://leetcode-cn.com/problems/lru-cache/
 */
public class LRUCache {

    private final Map<Integer, KVNode> map = new HashMap<>();
    private final KVNode head = new KVNode(-1, -1);
    private final KVNode tail = new KVNode(-1, -1);
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            KVNode node = map.get(key);
            node.val = value;

            node.prev.next = node.next;
            node.next.prev = node.prev;

            moveToHead(node);
            return;
        }
        KVNode node = new KVNode(key, value);
        map.put(key, node);

        moveToHead(node);

        if (map.size() > capacity) {
            map.remove(tail.prev.key);
            KVNode t = tail.prev;
            tail.prev = t.prev;
            t.prev.next = tail;
            t.prev = t.next = null;
        }


    }

    private void moveToHead(KVNode node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println();
    }
}
