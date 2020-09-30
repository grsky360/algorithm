package ilio.algorithm.string;

/**
 * @Author hyia
 * @Date 2020/09/30 18:04
 * @url https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class Atoi {

    public static int myAtoi(String str) {
        int res = 0;
        int sign = 1;

        int start = 0;
        while (start < str.length() && str.charAt(start) == ' ') {
            start++;
        }
        if (start == str.length()) {
            return 0;
        }
        if (str.charAt(start) == '+') {
            start++;
        } else {
            if (str.charAt(start) != '-' && parseNum(str.charAt(start)) == -1) {
                return 0;
            }
            if (str.charAt(start) == '-') {
                if ((start + 1 >= str.length() || parseNum(str.charAt(start + 1)) == -1)) {
                    return 0;
                }
                start++;
                sign = -1;
            }
        }
        while (start < str.length()) {
            int num = parseNum(str.charAt(start));
            if (num == -1) {
                break;
            }
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && num > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + sign * num;
            start++;
        }
        return res;
    }

    private static int parseNum(char ch) {
        return ch >= '0' && ch <= '9' ? ch - '0' : -1;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
    }
}
