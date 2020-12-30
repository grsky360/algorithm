package ilio.algorithm.leetcode.editor.cn;

import ilio.algorithm.data.*;

import java.util.*;

//找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
//
// 示例 1:
//
//
//输入:
//s = "aaabb", k = 3
//
//输出:
//3
//
//最长子串为 "aaa" ，其中 'a' 重复了 3 次。
//
//
// 示例 2:
//
//
//输入:
//s = "ababbc", k = 2
//
//输出:
//5
//
//最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
//
// Related Topics 递归 分治算法 Sliding Window
// 👍 256 👎 0


public class $395_LongestSubstringWithAtLeastKRepeatingCharacters {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static int longestSubstring(String s, int k) {
        int[][] count = new int[26][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int l = 0; l < 26; l++) {
                count[l][i + 1] = count[l][i];
            }
            count[s.charAt(i) - 'a'][i + 1]++;
        }
        return dfs(s, k, count, 0, s.length() - 1);
    }

    private static int dfs(String s, int k, int[][] count, int start, int end) {
        for (int i = start; i <= end; i++) {
            int index = s.charAt(i) - 'a';
            if (count[index][end + 1] - count[index][start] < k) {
                return Math.max(
                    dfs(s, k, count, start, i - 1),
                    dfs(s, k, count, i + 1, end));
            }
        }
        return Math.max(end - start + 1, 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        System.out.println(Solution.longestSubstring("aaabb", 3)); // 3
//        System.out.println(Solution.longestSubstring("eeaacaeebbbe", 3)); // 6
    }
}
