package ilio.algorithm.leetcode.editor.cn;

import ilio.algorithm.data.*;

import java.util.*;

//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。
//
//
//
// 示例 1：
//
//
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l"
//,"v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
//
//
// 示例 2：
//
//
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
//
//
//
//
// 提示：
//
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 12
// board[i][j] 是一个小写英文字母
// 1 <= words.length <= 3 * 104
// 1 <= words[i].length <= 10
// words[i] 由小写英文字母组成
// words 中的所有字符串互不相同
//
// Related Topics 字典树 回溯算法
// 👍 299 👎 0


public class $212_WordSearchIi {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode(new char[0], '\0');
        for (String word : words) {
            root.insert(word);
        }
        List<String> res = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                backtrack(res, row, col, board, root);
                if (res.size() == words.length) {
                    return res;
                }
            }
        }
        return res;
    }

    private void backtrack(List<String> res, int row, int col, char[][] board, TrieNode root) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        char ch = board[row][col];
        TrieNode node;
        if (ch == '^' || (node = root.links[ch - 'a']) == null || node.count == 0) {
            return;
        }
        if (node.end) {
            res.add(new String(node.word));
            node.end = false;
            node.count--;
        }
        board[row][col] = '^';
        if (row - 1 >= 0) {
            backtrack(res, row - 1, col, board, node);
        }
        if (row + 1 < board.length) {
            backtrack(res, row + 1, col, board, node);
        }
        if (col - 1 >= 0) {
            backtrack(res, row, col - 1, board, node);
        }
        if (col + 1 <= board[0].length) {
            backtrack(res, row, col + 1, board, node);
        }
        board[row][col] = ch;
    }

    public static class TrieNode {
        public final TrieNode[] links = new TrieNode[26];
        public final char[] word;
        public int count;
        public boolean end;

        public TrieNode(char[] word, char ch) {
            this.word = Arrays.copyOf(word, word.length + 1);
            this.word[this.word.length - 1] = ch;
        }

        public void insert(String word) {
            TrieNode curr = this;
            char[] prev = new char[0];
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (curr.links[index] == null) {
                    curr.links[index] = new TrieNode(prev, word.charAt(i));
                }
                curr = curr.links[index];
                prev = curr.word;
                curr.count++;
            }
            curr.end = true;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findWords(new char[][]{
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
        }, new String[]{"oath", "pea", "eat", "rain"}));// eat, oath

        System.out.println(solution.findWords(new char[][]{
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
        }, new String[]{"oath", "eat"}));// eat, oath

        System.out.println(solution.findWords(new char[][]{
            {'a', 'b'},
            {'c', 'd'}
        }, new String[]{"abcd"})); // empty

        System.out.println(solution.findWords(new char[][]{
            {'a', 'a'}
        }, new String[]{"a"})); // a
    }
}
