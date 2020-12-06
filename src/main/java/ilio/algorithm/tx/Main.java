package ilio.algorithm.tx;

import java.math.BigDecimal;

/**
 * @author zhongqingyang
 * 和为n的若干正整数的最大乘积
 **/
public class Main {

    public static void solution(int num) {
        BigDecimal res = BigDecimal.ZERO;
        int idx = 0;
        for (int i = 2; i < num; i++) {
            BigDecimal maxMultiplierResult = getMaxMultiplierResult(num, i);
            if (res.compareTo(maxMultiplierResult) < 0) {
                res = maxMultiplierResult;
                idx = i;
            }
        }
        System.out.println(num + ": " + idx + ", " + res);
    }

    public static BigDecimal getMaxMultiplierResult(int num, int k) {
        int avg = num / k;
        int overCount = num % k;
        return BigDecimal.valueOf(avg + 1).pow(overCount).multiply(BigDecimal.valueOf(avg).pow(k - overCount));
    }

    public static void main(String[] args) {
        solution(512);
        solution(513);
        solution(514);
        solution(515);
    }
}
