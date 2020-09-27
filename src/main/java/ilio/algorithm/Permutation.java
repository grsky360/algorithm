package ilio.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static String getPermutation(int n, int k) {
        int[] factorialMap = new int[n + 1];
        factorialMap[0] = factorialMap[1] = 1;
        for (int i = 2; i <= n; i++) {
            factorialMap[i] = i * factorialMap[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        k--;
        for (int i = n - 1; i >= 0; i--) {
            int index = k / factorialMap[i];
            k = k % factorialMap[i];
            sb.append(list.get(index));
            list.remove(index);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
    }
}
