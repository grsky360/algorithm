package ilio.algorithm.string;

/**
 * @Author hyia
 * @Date 2020/09/25 17:01
 */
public class CommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < strs[i].length() && j < res.length(); j++) {
                if (strs[i].charAt(j) != res.charAt(j)) {
                    break;
                }
            }
            res = res.substring(0, j);
            if (res.equals("")) {
                break;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"abc", "abcd", "afe"}));
    }
}
