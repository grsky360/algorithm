package ilio.algorithm.string;

/**
 * @Author hyia
 * @Date 2020/09/25 17:15
 * @Url https://leetcode-cn.com/problems/simplify-path/
 */
public class SimplifyPath {

    public static String simplifyPath(String path) {
        String[] paths = path.split("[/]+");
        String[] queues = new String[paths.length];
        int end = 0;
        for (String p : paths) {
            if (p.equals(".") || p.equals("")) {
                continue;
            }
            if (p.equals("..")) {
                if (end != 0) {
                    end--;
                }
                continue;
            }
            queues[end++] = p;
        }
        if (end == 0) {
            return "/";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < end; i++) {
            res.append("/").append(queues[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
    }
}
