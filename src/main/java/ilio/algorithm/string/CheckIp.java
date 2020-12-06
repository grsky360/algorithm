package ilio.algorithm.string;

/**
 * @Author hyia
 * @url https://leetcode-cn.com/problems/validate-ip-address/
 */
public class CheckIp {

    public static String validIPAddress(String ip) {
        if (ip.contains(":")) {
            if (checkIpv6(ip)) {
                return "IPv6";
            }
        } else if (ip.contains(".")) {
            if (checkIpv4(ip)) {
                return "IPv4";
            }
        }
        return "Neither";
    }

    private static boolean checkIpv4(String ip) {
        String[] codes = ip.split("\\.");
        if (codes.length != 4) {
            return false;
        }
        for (String code : codes) {
            if (code.length() > 3 || code.length() == 0) {
                return false;
            }
            if (code.charAt(0) == '0' && code.length() != 1) {
                return false;
            }
            for (char ch : code.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    return false;
                }
            }
            if (Integer.valueOf(code) > 255) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkIpv6(String ip) {
        String[] codes = ip.split(":", -1);
        String hex = "0123456789abcdefABCDEF";
        if (codes.length != 8) {
            return false;
        }
        for (String code : codes) {
            if (code.length() == 0 || code.length() > 4) {
                return false;
            }
            for (char ch : code.toCharArray()) {
                if (hex.indexOf(ch) == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validIPAddress("172.16.254.1"));
        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }
}
