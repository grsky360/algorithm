package ilio.algorithm.leetcode.editor.cn;

import ilio.algorithm.data.*;

import java.util.*;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例：
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
//
// Related Topics 字符串 回溯算法
// 👍 1485 👎 0


public class $22_GenerateParentheses {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder builder, int left, int right, int n) {
        if (builder.length() == n * 2) {
            res.add(builder.toString());
            return;
        }
        if (left < n) {
            builder.append("(");
            backtrack(res, builder, left + 1, right, n);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (right < left) {
            builder.append(")");
            backtrack(res, builder, left, right + 1, n);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {

    }
}
