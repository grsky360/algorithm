package ilio.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int target = -nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int cur = nums[l] + nums[r];
                if (cur == target) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if (cur > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-2, 0, 1, 1, 2}));
        System.out.println();
    }
}
