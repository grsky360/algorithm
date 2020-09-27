package ilio.algorithm.other;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArray {

    static class Solution {
        private final int[] nums;
        private static final ThreadLocalRandom random = ThreadLocalRandom.current();

        public Solution(int[] nums) {
            this.nums = nums;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return nums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            int[] nums = new int[this.nums.length];
            System.arraycopy(this.nums, 0, nums, 0, this.nums.length);
            for (int i = 0; i < nums.length; i++) {
                int index = random.nextInt(nums.length);
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
            }
            return nums;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution(new int[]{1, 3, 5, 7, 9}).shuffle()));
    }
}
