package ilio.algorithm.ms;

import java.util.Arrays;

public class Main {
    public static int[] solution(int N) {
        int[] res = new int[N];
        if (N <= 1) {
            return res;
        }
        for (int i = 0; i < N / 2; i++) {
            res[i] = i + 1;
            res[N - i - 1] = -(i + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2)));
    }
}
