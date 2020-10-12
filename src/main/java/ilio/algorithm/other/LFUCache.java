package ilio.algorithm.other;

import ilio.algorithm.data.FrequentKVNode;
import ilio.algorithm.data.LinkedNodeRoot;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hyia
 * @Date 2020/09/25 13:09
 * @url https://leetcode-cn.com/problems/lru-cache/
 */
public class LFUCache {

    private final Map<Integer, FrequentKVNode> map = new HashMap<>();
    private final Map<Integer, LinkedNodeRoot> frequentMap = new HashMap<>();
    private final int capacity;
    private int minFrequent;

    public LFUCache(int capacity) {
        this.capacity = capacity;
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
        if (capacity == 0) {
            return;
        }
        if (map.containsKey(key)) {
            FrequentKVNode node = map.get(key);
            node.val = value;
            int frequent = node.frequent;
            LinkedNodeRoot oldRoot = frequentMap.get(frequent);
            frequentMap.get(frequent).remove(node);
            if (frequent == minFrequent && oldRoot.isEmpty()) {
                minFrequent++;
            }
            node.frequent++;
            LinkedNodeRoot newRoot = frequentMap.computeIfAbsent(node.frequent, k -> new LinkedNodeRoot());
            newRoot.add(node);
            return;
        }

        FrequentKVNode node = new FrequentKVNode(key, value);
        node.frequent = 1;
        map.put(key, node);
        frequentMap.computeIfAbsent(node.frequent, k -> new LinkedNodeRoot()).add(node);

        if (map.size() > capacity) {
            LinkedNodeRoot root = frequentMap.get(minFrequent);
            map.remove(root.head.next.key);
            root.remove(root.head.next);
            if (root.isEmpty()) {
                frequentMap.remove(minFrequent);
            }
        }
        this.minFrequent = 1;
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(0);
        cache.put(0, 0);
        System.out.println(cache.get(0));
    }
}
