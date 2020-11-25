package ilio.algorithm.string;

/**
 * @Author hyia
 * @Date 2020/10/10 22:48
 * @url https://leetcode-cn.com/problems/valid-palindrome-ii/
 */
public class ValidPalindrome {

    public static boolean validPalindrome(String s) {
        int l = 0,
            r = s.length() - 1;
        while (l < r) {
            char lch = s.charAt(l);
            char rch = s.charAt(r);
            if (lch == rch) {
                l++;
                r--;
            } else {
                int low = l,
                    high = r - 1;
                boolean valid = true;
                while (low < high) {
                    lch = s.charAt(low++);
                    rch = s.charAt(high--);
                    if (lch != rch) {
                        valid = false;
                        break;
                    }
                }
                if (!valid) {
                    low = l + 1;
                    high = r;
                    while (low < high) {
                        lch = s.charAt(low++);
                        rch = s.charAt(high--);
                        if (lch != rch) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("aba")); // true
        System.out.println(validPalindrome("abca")); // true
        System.out.println(validPalindrome("abc")); // false
        System.out.println(validPalindrome("abvvbcca"));
    }
}
