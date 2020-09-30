package ilio.algorithm.other;

/**
 * @Author hyia
 * @Date 2020/09/30 19:27
 * @url https://leetcode-cn.com/problems/find-the-duplicate-number/
 */
public class DuplicateNumber {

    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (slow == fast) {
                fast = 0;
                while (nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[fast];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }
}
