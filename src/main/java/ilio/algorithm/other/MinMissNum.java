package ilio.algorithm.other;

/**
 * @author hyia
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 * Given A = [1, 2, 3], the function should return 4.
 *
 * Given A = [−1, −3], the function should return 1.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class MinMissNum {

    public static int solution(int[] A) {
        int l = 0;
        int r = A.length;
        while (l < r) {
            if (A[l] == l + 1) {
                l++;
            } else if (A[l] < l + 1 || A[l] > r) {
                r--;
                A[l] = A[r];
            } else {
                if (A[l] == A[A[l] - 1]) {
                    r--;
                    A[l] = A[r];
                } else {
                    swap(A, l, A[l] - 1);
                }
            }
        }
        return l + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 6, 4, 1, 2}));
    }
}
