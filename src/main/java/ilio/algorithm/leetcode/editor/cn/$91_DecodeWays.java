package ilio.algorithm.leetcode.editor.cn;

import ilio.algorithm.data.*;

import java.util.*;

//一条包含字母 A-Z 的消息通过以下方式进行了编码：
//
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。
//
// 题目数据保证答案肯定是一个 32 位的整数。
//
//
//
// 示例 1：
//
//
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
//
//
// 示例 2：
//
//
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
//
//
// 示例 3：
//
//
//输入：s = "0"
//输出：0
//
//
// 示例 4：
//
//
//输入：s = "1"
//输出：1
//
//
// 示例 5：
//
//
//输入：s = "2"
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 100
// s 只包含数字，并且可能包含前导零。
//
// Related Topics 字符串 动态规划
// 👍 582 👎 0


public class $91_DecodeWays {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if (num != 0) {
                dp[i] = dp[i - 1];
            }
            int sum = num + (s.charAt(i - 1) - '0') * 10;
            if (sum >= 10 && sum <= 26) {
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length() - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {

    }
}
