package ilio.algorithm.other;

import java.util.Arrays;

/**
 * @Author hyia
 * @Date 2020/10/04 17:48
 * @url https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 */
public class SpiralOrder {

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] res = new int[rows * cols];
        int idx = 0;
        int top = 0, bot = rows - 1;
        int left = 0, right = cols - 1;
        while (top <= bot && left <= right) {
            for (int col = left; col <= right; col++) {
                res[idx++] = matrix[top][col];
            }
            for (int row = top + 1; row <= bot; row++) {
                res[idx++] = matrix[row][right];
            }
            if (left < right && top < bot) {
                for (int col = right - 1; col > left; col--) {
                    res[idx++] = matrix[bot][col];
                }
                for (int row = bot; row > top; row--) {
                    res[idx++] = matrix[row][left];
                }
            }
            top++;
            bot--;
            left++;
            right--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(spiralOrder(new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        })));
        System.out.println(Arrays.toString(spiralOrder(new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        })));
    }
}
