package ilio.algorithm.leetcode.editor.cn;

import ilio.algorithm.data.*;
import lombok.val;

import java.util.*;

//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1055 👎 0


public class $146_LruCache {
static
//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    private final Map<Integer, KVNode> map;
    private final KVNode head, tail;
    private final int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity + 1, 1);
        this.head = new KVNode(-1, -1);
        this.tail = new KVNode(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.capacity = capacity;
    }

    public int get(int key) {
        KVNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        put(node.key, node.val);
        return node.val;
    }

    public void put(int key, int value) {
        KVNode node = map.get(key);
        if (node != null) {
            node.val = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            moveToHead(node);
            return;
        }
        node = new KVNode(key, value);
        map.put(key, node);
        moveToHead(node);
        if (map.size() > capacity) {
            KVNode removal = tail.prev;
            map.remove(removal.key);
            tail.prev = removal.prev;
            tail.prev.next = tail;
        }
    }

    private void moveToHead(KVNode node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private static class KVNode {
        public final int key;
        public int val;
        public KVNode prev, next;

        public KVNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

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
    }
}
