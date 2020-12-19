package ilio.algorithm.test;

public class ToZero {

    public static int toZero(int num) {
        int cnt = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num >>= 1;
            } else {
                num -= 1;
            }
            cnt++;
        }
        return cnt;
    }

    public static int toZero2(int num) {
        int cnt = 1;
        while (num != 1) {
            if ((num & 1) == 1) {
                cnt += 2;
            } else {
                cnt++;
            }
            num >>= 1;
        }
        return cnt;
    }

    public static void diff(int num) {
        System.out.println(toZero(num));
        System.out.println(toZero2(num));
    }

    public static void main(String[] args) {
        diff(129);
        diff(149);
    }
}
