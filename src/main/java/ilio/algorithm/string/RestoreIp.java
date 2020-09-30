package ilio.algorithm.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author hyia
 * @Date 2020/09/25 18:05
 * @url https://leetcode-cn.com/problems/restore-ip-addresses/
 */
public class RestoreIp {

    public static List<String> restoreIpAddresses(String s) {
        if (s.length() == 0 || s.length() > 12) {
            return Collections.emptyList();
        }
        List<String> res = new ArrayList<>();
        // TODO
        return res;
    }

    private static boolean isValid(String s, int start, int end) {
        if (start > end || end - start + 1 > 3) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        return s.substring(start, end + 1).compareTo("255") < 0;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("255"));
        System.out.println(isValid("255255255255", 1, 3));
    }
}
