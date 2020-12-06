package ilio.algorithm.test;

/**
 * @author zhongqingyang
 **/
public class ReverseWords {

    public static String reverse(String s) {
        StringBuilder string = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            int j = i;
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }
            string.append(s, j + 1, i + 1).append(" ");
            i = j;
        }

        return string.toString().trim();
    }

    public static void main(String[] args) {
        System.out.printf(reverse("   a  bcc cd  "));
    }

}
