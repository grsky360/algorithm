package ilio.algorithm.leetcode.editor.cn;

import ilio.algorithm.data.*;

import java.util.*;

//实现一个基本的计算器来计算一个简单的字符串表达式的值。
//
// 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。
//
// 示例 1:
//
// 输入: "3+2*2"
//输出: 7
//
//
// 示例 2:
//
// 输入: " 3/2 "
//输出: 1
//
// 示例 3:
//
// 输入: " 3+5 / 2 "
//输出: 5
//
//
// 说明：
//
//
// 你可以假设所给定的表达式都是有效的。
// 请不要使用内置的库函数 eval。
//
// Related Topics 栈 字符串
// 👍 237 👎 0


public class $227_BasicCalculatorIi {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Deque<Character> opDeque = new LinkedList<>();
        Deque<Integer> numDeque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            }
            if (Character.isDigit(ch)) {
                int n = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    n = n * 10 + s.charAt(i) - '0';
                    i++;
                }
                numDeque.offerLast(n);
                i--;
                continue;
            }

            int level = level(ch);
            while (!opDeque.isEmpty() && level <= level(opDeque.getLast())) {
                char op = opDeque.removeLast();
                int num2 = numDeque.removeLast();
                int num1 = numDeque.removeLast();
                int num = calc(op, num1, num2);
                numDeque.offerLast(num);
            }
            opDeque.offerLast(ch);
        }
        while (!opDeque.isEmpty()) {
            char op = opDeque.removeLast();
            int num2 = numDeque.removeLast();
            int num1 = numDeque.removeLast();
            int num = calc(op, num1, num2);
            numDeque.offerLast(num);
        }
        return numDeque.getLast();
    }

    public static int level(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        }
        if (ch == '*' || ch == '/') {
            return 2;
        }
        return 0;
    }

    public static int calc(char ch, int num1, int num2) {
        switch (ch) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
//        System.out.println(Solution.calculate("1 * 2 + 3")); // 5
//        System.out.println(Solution.calculate("3+2* 2")); // 7
//        System.out.println(Solution.calculate("3 /2")); // 1
//        System.out.println(Solution.calculate("3 + 5 / 2")); // 5
        System.out.println(Solution.calculate("1 - 1 + 1")); // 1
    }
}
