package ilio.algorithm.string;

/**
 * @Author hyia
 * @Date 2020/09/24 19:40
 * @url https://leetcode-cn.com/problems/multiply-strings/
 */
public class StringMultiply {

    public static String multiply(String num1, String num2) {
        char[] chs1 = num1.toCharArray();
        char[] chs2 = num2.toCharArray();

        int[] res = new int[chs1.length + chs2.length];
        for (int i = chs1.length - 1; i >= 0; i--) {
            for (int j = chs2.length - 1; j >= 0; j--) {
                int num = (chs1[i] - '0') * (chs2[j] - '0');
                res[i + j + 1] += num;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = res.length - 1; i >= 0; i--) {
            if (i != 0) {
                res[i - 1] += res[i] / 10;
            }
            builder.insert(0, res[i] % 10);
        }
        while (builder.length() != 1 && builder.charAt(0) == '0') {
            builder.delete(0, 1);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("101", "9819"));
    }


}
