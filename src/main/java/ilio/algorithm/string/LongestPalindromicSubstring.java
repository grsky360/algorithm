package ilio.algorithm.string;

/**
 * @Author hyia
 * @Date 2020/10/12 13:06
 * @url https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome1(String s) {
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
                    dp[i][j] = (lch == rch);
                } else {
                    dp[i][j] = (lch == rch) && dp[i + 1][j - 1];
                }
                if (dp[i][j] && (l + 1) > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public static String longestPalindrome2(String s) {
        if (s.length() < 2) {
            return s;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(expand(s, i, i), expand(s, i, i + 1));
            if (len > (right - left)) {
                left = i - ((len - 1) >> 1);
                right = i + (len >> 1);
            }
        }
        return s.substring(left, right + 1);
    }

    private static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
