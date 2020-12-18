package ilio.algorithm.leetcode.editor.cn;

import ilio.algorithm.data.*;

import java.util.*;

//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 288 👎 0


public class $415_AddStrings {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        if ("0".equals(num1)) {
            return num2;
        }
        if ("0".equals(num2)) {
            return num1;
        }
        char[] res = new char[Math.max(num1.length(), num2.length()) + 1];
        res[0] = '0';
        int carry = 0;
        int i1 = num1.length();
        int i2 = num2.length();
        int idx = res.length - 1;
        while (i1 >= 0 || i2 >= 0 || carry != 0) {
            int num = carry;
            if (i1 >= 0) {
                num += num1.charAt(i1--) - '0';
            }
            if (i2 >= 0) {
                num += num2.charAt(i2--) - '0';
            }
            res[idx--] = (char) ('0' + num % 10);
            carry = num / 10;
        }
        if (res[0] == '0') {
            return new String(res, 1, res.length - 1);
        } else {
            return new String(res);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        
    }
}