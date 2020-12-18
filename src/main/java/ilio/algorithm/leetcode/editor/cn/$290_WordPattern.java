package ilio.algorithm.leetcode.editor.cn;

import ilio.algorithm.data.*;

import java.util.*;

//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 
// 👍 284 👎 0


public class $290_WordPattern {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        int i = 0;
        for (int j = 0; j < pattern.length(); j++) {
            if (i >= s.length()) {
                return false;
            }
            char ch = pattern.charAt(j);
            int k = i;
            while (k < s.length() && s.charAt(k) != ' ') {
                k++;
            }
            String sub = s.substring(i, k);
            if (map1.containsKey(ch) && !map1.get(ch).equals(sub)) {
                return false;
            }
            if (map2.containsKey(sub) && !map2.get(sub).equals(ch)) {
                return false;
            }
            map1.put(ch, sub);
            map2.put(sub, ch);
            i = k + 1;
        }
        return i >= s.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        
    }
}