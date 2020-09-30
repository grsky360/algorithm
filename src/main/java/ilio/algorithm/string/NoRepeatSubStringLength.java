package ilio.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hyia
 * @Date 2020/09/24 20:04
 * @url https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class NoRepeatSubStringLength {

    public static int lengthOfLongestSubstring(String s) {
        int res = 0;

        Map<Character, Integer> cache = new HashMap<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            left = Math.max(left, cache.getOrDefault(ch, -1));
            res = Math.max(res, i - left + 1);
            cache.put(ch, i + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("123412312345612345678901234"));
    }
}
