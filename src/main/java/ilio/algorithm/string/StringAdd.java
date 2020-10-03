package ilio.algorithm.string;

/**
 * @Author hyia
 * @Date 2020/10/03 14:06
 */
public class StringAdd {

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int num = carry;
            if (i >= 0) {
                num += num1.charAt(i) - '0';
            }
            if (j >= 0) {
                num += num2.charAt(j) - '0';
            }
            res.append(num % 10);
            carry = num / 10;
            i--;
            j--;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("1", "2"));
        System.out.println(addStrings("99999", "9991"));
    }
}
