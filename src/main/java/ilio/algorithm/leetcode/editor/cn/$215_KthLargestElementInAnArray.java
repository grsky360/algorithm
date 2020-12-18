package ilio.algorithm.leetcode.editor.cn;

import ilio.algorithm.data.*;

import java.util.*;

//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 826 👎 0


public class $215_KthLargestElementInAnArray {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0 || k <= 0 || k > nums.length) {
            return -1;
        }
        int idx = partition(nums, 0, nums.length - 1);
        while (k - 1 != idx) {
            if (k - 1 < idx) {
                idx = partition(nums, 0, idx - 1);
            } else {
                idx = partition(nums, idx + 1, nums.length - 1);
            }
        }
        return nums[idx];
    }

    private int partition(int[] nums, int i, int j) {
        int key = nums[i];
        while (i < j) {
            while (i < j && nums[j] <= key) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
            }
            while (i < j && nums[i] >= key) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
            }
        }
        nums[i] = key;
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        
    }
}
