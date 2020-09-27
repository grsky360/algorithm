package leetcode;

public class RotatedArraySearch {

    public static int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[i] == target) {
                return i;
            }
            if (nums[j] == target) {
                return j;
            }
            if (nums[i] < nums[mid]) {
                if (target < nums[mid] && target > nums[i]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                if (target > nums[mid] && target < nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1}, 1));
        System.out.println();
    }
}
