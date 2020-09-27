package leetcode;

import java.util.Arrays;

public class S1 {

    public static String multiply(String num1, String num2) {
        String base = num1.length() > num2.length() ? num1 : num2;
        String that = num1.length() <= num2.length() ? num1 : num2;
        String res = "0";
        for (int i = that.length() - 1; i >= 0; i--) {
            String num = multiply(base, that.charAt(i));
            String zero = String.valueOf((int) Math.pow(10, that.length() - i - 1)).substring(1);

            res = plus(res, num + zero);
        }
        return cleanZero(res);
    }

    public static String cleanZero(String num) {
        num = num.replaceFirst("^[0]+", "");
        return num.isEmpty() ? "0" : num;
    }

    public static String plus(String num1, String num2) {
        int size = Math.max(num1.length(), num2.length());
        int[] numa1 = toIntArray(num1, size);
        int[] numa2 = toIntArray(num2, size);
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = size - 1; i >= 0; i--) {
            int num = numa1[i] + numa2[i] + carry;
            carry = num / 10;
            res.insert(0, num % 10);
        }
        if (carry != 0) {
            res.insert(0, carry);
        }
        return res.toString();
    }

    public static int[] toIntArray(String num, int size) {
        int[] res = new int[Math.max(num.length(), size)];
        for (int i = res.length - 1; i >= 0; i--) {
            if (i >= res.length - num.length()) {
                res[i] = num.charAt(i - (res.length - num.length())) - '0';
            } else {
                res[i] = 0;
            }
        }
        return res;
    }

    public static String multiply(String str, char that) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int base = that - '0';
        for (int i = str.length() - 1; i >= 0; i--) {
            int num1 = str.charAt(i) - '0';
            int num = num1 * base + carry;
            carry = num / 10;
            res.insert(0, num % 10);
        }
        if (carry != 0) {
            res.insert(0, carry);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("1112", "0"));
        System.out.println(plus("999", "99"));
        System.out.println(Arrays.toString(toIntArray("123", 5)));
    }
}
