package ilio.algorithm.ab;

/**
 * @author zhongqingyang
 **/
public class SplitString {

    public static String solution(String s) {
        StringBuilder builder = new StringBuilder();
        boolean quota = false;
        char[] chs = s.toCharArray();
        int i = 0;
        while (i < chs.length) {
            char ch = chs[i];
            if (ch == '"') {
                if (!quota) {
                    quota = true;
                    while (chs[++i] == '"') {
                        builder.append(ch);
                    }
                } else {
                    quota = false;
                    while (chs[++i] == '"') {
                        builder.append(ch);
                    }
                }
                i--;
            } else if (ch == ',' && !quota) {
                builder.append("|");
            } else {
                builder.append(ch);
            }
            i++;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        // rwer321,dad,adas,ytruty,yihgf
        // rwer321|dad|adas|ytruty|yihgf
        System.out.println(solution("rwer321,dad,adas,ytruty,yihgf"));
        // "ha,ua",sa,da,""da,da"",dad
        // ha,ua|sa|da|"da,da"|dad
        System.out.println(solution("\"ha,ua\",sa,da,\"\"da,da\"\",dad"));
        // dasd,""asddad"",fsfsf,gdfg,1
        // dasd|"asddad"|fsfsf|gdfg|1
        System.out.println(solution("dasd,\"\"asddad\"\",fsfsf,gdfg,1"));
        // "ha,ua",sa,da,"""da,da""",dad
        // ha,ua|sa|da|""da,da""|dad
        System.out.println(solution("\"ha,ua\",sa,da,\"\"\"da,da\"\"\",dad"));
    }
}
