package ilio.algorithm.string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author hyia
 * @Date 2020/10/03 20:35
 * @url https://leetcode-cn.com/problems/valid-parentheses/
 */
public class ValidBracket {

    public static boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        Deque<Character> deque = new LinkedList<>();
        deque.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                deque.push(ch);
            } else {
                if (deque.isEmpty()) {
                    return false;
                }
                char left = deque.remove();
                char right = ch;
                if (!((left == '(' && right == ')') ||
                    (left == '[' && right == ']') ||
                    (left == '{' && right == '}'))) {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));      // true
        System.out.println(isValid("()[]{}"));  // true
        System.out.println(isValid("(]"));      // false
        System.out.println(isValid("([)]"));    // false
        System.out.println(isValid("{[]}"));    // true
    }
}
