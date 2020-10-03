package ilio.algorithm.other;

import java.util.Arrays;

/**
 * @Author hyia
 * @Date 2020/10/03 20:49
 * @url https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZero {

    public static void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (i < nums.length) {
                while (i < nums.length && nums[i] == 0) {
                    i++;
                }
                if (i < nums.length) {
                    nums[j++] = nums[i++];
                }
            } else {
                nums[j++] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
