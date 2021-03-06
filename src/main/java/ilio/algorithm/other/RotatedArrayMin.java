package ilio.algorithm.other;

/**
 * @Author hyia
 * @url https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * */
public class RotatedArrayMin {

    public static int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > nums[j]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return nums[i];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
    }
}
