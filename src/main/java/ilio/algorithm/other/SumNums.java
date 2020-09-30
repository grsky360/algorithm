package ilio.algorithm.other;

/**
 * @Author hyia
 * @Date 2020/09/30 18:34
 */
public class SumNums {

    public static int sumNums(int n) {
        boolean ignored = n > 1 && ((n = n + sumNums(n - 1)) > 0);
        return n;
    }

    public static void main(String[] args) {
        System.out.println(sumNums(1));
        System.out.println(sumNums(2));
        System.out.println(sumNums(3));
    }
}
