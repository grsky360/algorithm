package ilio.algorithm.leetcode.editor.cn;

import ilio.algorithm.data.*;

import java.util.*;

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 3007 👎 0


public class $5_LongestPalindromicSubstring {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        String res = "";
        for (int l = 0; l < length; l++) {
            for (int i = 0; i + l < length; i++) {
                int j = i + l;
                char lch = s.charAt(i);
                char rch = s.charAt(j);
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = lch == rch;
                } else {
                    dp[i][j] = lch == rch && dp[i + 1][j - 1];
                }
                if (dp[i][j] && res.length() < (l + 1)) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        
    }
}