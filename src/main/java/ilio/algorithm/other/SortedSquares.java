package ilio.algorithm.other;

import java.util.Arrays;

/**
 * @Author hyia
 * @Date 2020/10/06 21:03
 */
public class SortedSquares {

    public static int[] sortedSquares(int[] A) {
        if (A.length == 0) {
            return A;
        }
        int[] res = new int[A.length];
        int left = 0;
        int right = A.length - 1;
        int idx = res.length - 1;
        while (idx >= 0) {
            if (Math.abs(A[left]) < Math.abs(A[right])) {
                res[idx--] = A[right] * A[right];
                right--;
            } else {
                res[idx--] = A[left] * A[left];
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7, -3, 2, 3, 11})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }
}
