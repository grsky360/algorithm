package ilio.algorithm.leetcode.editor.cn;

import ilio.algorithm.data.*;

import java.util.*;

//给你两个二进制字符串，返回它们的和（用二进制表示）。
//
// 输入为 非空 字符串且只包含数字 1 和 0。
//
//
//
// 示例 1:
//
// 输入: a = "11", b = "1"
//输出: "100"
//
// 示例 2:
//
// 输入: a = "1010", b = "1011"
//输出: "10101"
//
//
//
// 提示：
//
//
// 每个字符串仅由字符 '0' 或 '1' 组成。
// 1 <= a.length, b.length <= 10^4
// 字符串如果不是 "0" ，就都不含前导零。
//
// Related Topics 数学 字符串
// 👍 531 👎 0


public class $67_AddBinary {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int num = carry;
            if (i >= 0) {
                num += a.charAt(i) - '0';
            }
            if (j >= 0) {
                num += b.charAt(j) - '0';
            }
            res.append(num & 1);
            carry = num >> 1;
        }
        if (carry == 1) {
            res.append(carry);
        }
        return res.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {

    }
}
