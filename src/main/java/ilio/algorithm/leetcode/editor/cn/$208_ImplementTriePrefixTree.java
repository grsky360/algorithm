package ilio.algorithm.leetcode.editor.cn;

import ilio.algorithm.data.*;

import java.util.*;

//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。 
//
// 示例: 
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");   
//trie.search("app");     // 返回 true 
//
// 说明: 
//
// 
// 你可以假设所有的输入都是由小写字母 a-z 构成的。 
// 保证所有输入均为非空字符串。 
// 
// Related Topics 设计 字典树 
// 👍 487 👎 0


public class $208_ImplementTriePrefixTree {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Trie {
    public final TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.links[index] == null) {
                curr.links[index] = new TrieNode();
            }
            curr = curr.links[index];
        }
        curr.end = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.links[index] == null) {
                return false;
            }
            curr = curr.links[index];
        }
        return curr.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (curr.links[index] == null) {
                return false;
            }
            curr = curr.links[index];
        }
        return true;
    }

    public static class TrieNode {
        public final TrieNode[] links = new TrieNode[26];
        public boolean end;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        
    }
}
