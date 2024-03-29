package ilio.algorithm.leetcode.editor.cn;

import ilio.algorithm.data.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

//给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
//
// 实现 Solution class:
//
//
// Solution(int[] nums) 使用整数数组 nums 初始化对象
// int[] reset() 重设数组到它的初始状态并返回
// int[] shuffle() 返回数组随机打乱后的结果
//
//
//
//
// 示例：
//
//
//输入
//["Solution", "shuffle", "reset", "shuffle"]
//[[[1, 2, 3]], [], [], []]
//输出
//[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
//
//解释
//Solution solution = new Solution([1, 2, 3]);
//solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3,
//1, 2]
//solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
//solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 200
// -106 <= nums[i] <= 106
// nums 中的所有元素都是 唯一的
// 最多可以调用 5 * 104 次 reset 和 shuffle
//
// 👍 111 👎 0


public class $384_ShuffleAnArray {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private final int[] nums;
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    public Solution(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] nums = Arrays.copyOf(this.nums, this.nums.length);
        for (int i = 0; i < nums.length; i++) {
            int index = random.nextInt(nums.length);
            int tmp = nums[i];
            nums[i] = nums[index];
            nums[index] = tmp;
        }
        return nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {

    }
}
