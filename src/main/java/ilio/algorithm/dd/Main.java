package ilio.algorithm.dd;

/**
 * @author zhongqingyang
 **/
public class Main {

    public static int solution(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        if (arr.length == 2) {
            return Math.max(arr[0], arr[1]);
        }

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = arr[1];
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 5, 3, 1, 7})); // 12
        System.out.println(solution(new int[]{1, 5, 3, 8, 7, 12})); // 25

    }
}
