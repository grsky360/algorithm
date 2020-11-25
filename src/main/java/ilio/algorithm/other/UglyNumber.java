package ilio.algorithm.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author hyia
 * @Date 2020/10/10 16:15
 * @url https://leetcode-cn.com/problems/ugly-number/
 * @url https://leetcode-cn.com/problems/ugly-number-ii/
 * @url https://leetcode-cn.com/problems/ugly-number-iii/
 */
public class UglyNumber {

    public static boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }

    public static int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int i2 = 0,
            i3 = 0,
            i5 = 0;
        for (int i = 1; i < n; i++) {
            int n2 = res[i2] * 2;
            int n3 = res[i3] * 3;
            int n5 = res[i5] * 5;
            int min = Math.min(Math.min(n2, n3), n5);
            res[i] = min;
            if (min == n2) {
                i2++;
            }
            if (min == n3) {
                i3++;
            }
            if (min == n5) {
                i5++;
            }
        }
        return res[n - 1];
    }

    public static int nthUglyNumber(int n, int a, int b, int c) {
        final long ab = lcm(a, b);
        final long ac = lcm(a, c);
        final long bc = lcm(b, c);
        final long abc = lcm(ab, c);

        long left = Math.min(Math.min(a, b), c);
        long right = left * n;
        while (left < right) {
            long mid = (left + right) >> 1;
            long count = mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / abc;
            if (count < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (int) left;
    }

    private static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    private static long gcd(long x, long y) {
        if (x == 0) return y;
        return gcd(y % x, x);
    }

    public static void main(String[] args) {
        System.out.println(isUgly(6)); // true
        System.out.println(isUgly(8)); // true
        System.out.println(isUgly(14)); // false
        System.out.println();
        System.out.println(nthUglyNumber(10)); // 12
        System.out.println();
        System.out.println(nthUglyNumber(9, 2, 3, 5)); // 12
        System.out.println(nthUglyNumber(3, 2, 3, 5)); // 4
        System.out.println(nthUglyNumber(4, 2, 3, 4)); // 6
        System.out.println(nthUglyNumber(5, 2, 11, 13)); // 10
        System.out.println(nthUglyNumber(1000000000, 2, 217983653, 336916467)); // 1999999984
    }
}
