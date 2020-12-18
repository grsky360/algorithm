package ilio.algorithm.leetcode.editor.cn;

import ilio.algorithm.data.*;

import java.util.*;

//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划 
// 👍 785 👎 0


public class $139_WordBreak {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        for (String word : wordDict) {
            insert(root, word);
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[s.length()];
        visit[0] = true;
        queue.offer(0);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            List<Integer> list = searchAllPrefix(root, s, start);
            for (int end : list) {
                if (end == s.length() - 1) {
                    return true;
                }
                if (visit[end + 1]) {
                    continue;
                }
                queue.add(end + 1);
                visit[end + 1] = true;
            }
        }
        return false;
    }

    private List<Integer> searchAllPrefix(TrieNode root, String prefix, int start) {
        List<Integer> list = new ArrayList<>();
        TrieNode node = root;
        for (int i = start; i < prefix.length(); i++) {
            node = node.links[prefix.charAt(i) - 'a'];
            if (node == null) {
                break;
            }
            if (node.end) {
                list.add(i);
            }
        }
        return list;
    }

    public void insert(TrieNode root, String word) {
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

    public static class TrieNode {
        public final TrieNode[] links = new TrieNode[26];
        public boolean end;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordBreak("leetcode", Arrays.asList("leet", "code"))); // true
        System.out.println(solution.wordBreak("applepenapple", Arrays.asList("apple", "pen"))); // true
        System.out.println(solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"))); // false
        System.out.println(solution.wordBreak("ab", Arrays.asList("a", "b")));
    }
}
