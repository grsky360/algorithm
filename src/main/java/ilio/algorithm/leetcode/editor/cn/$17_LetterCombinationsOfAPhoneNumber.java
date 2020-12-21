package ilio.algorithm.leetcode.editor.cn;

import ilio.algorithm.data.*;

import java.util.*;
import java.util.function.Function;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
// 示例:
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// 说明:
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
// Related Topics 深度优先搜索 递归 字符串 回溯算法
// 👍 1046 👎 0


public class $17_LetterCombinationsOfAPhoneNumber {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), digits.toCharArray(), 0);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder builder, char[] chars, int i) {
        if (i >= chars.length) {
            res.add(builder.toString());
            return;
        }
        int num = chars[i] - '0';
        char[] codes = generate(num);
        for (int j = 0; j < codes.length; j++) {
            builder.append(codes[j]);
            backtrack(res, builder, chars, i + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    private static char[] generate(int num) {
        int offset = num == 7 || num == 9 ? 4 : 3;
        char[] res = new char[offset];
        for (int i = 0; i < offset; i++) {
            char ch = (char) ('a' + (num - 2) * 3 + (num > 7 ? 1 : 0) + i);
            res[i] = ch;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Function<Integer, List<Character>> function = (num) -> {
            int offset = num == 9 || num == 7 ? 4 : 3;
            List<Character> res = new ArrayList<>();
            for (int j = 0; j < offset; j++) {
                char ch = (char) ('a' + (num - 2) * 3 +(num > 7 ? 1 : 0) + j);
                res.add(ch);
            }
            return res;
        };

        System.out.println(function.apply(1));
    }
}
