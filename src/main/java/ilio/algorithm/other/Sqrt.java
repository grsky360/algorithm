package ilio.algorithm.other;

/**
 * @Author hyia
 * @Date 2020/09/25 10:53
 * @url https://leetcode-cn.com/problems/sqrtx/
 */
public class Sqrt {

    public static int sqrt(int x) {
        int left = 0;
        int right = x;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int val = 2147395600;
        System.out.println(sqrt(val));
        System.out.println((int) Math.sqrt(val));
    }
}
