package ilio.algorithm.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhongqingyang
 * @url https://leetcode-cn.com/problems/permutations-ii/description/
 **/
public class PermuteUnique {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), new boolean[nums.length], res);
        return res;
    }

    private static void dfs(int[] nums, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 此处!used[i - 1]表示同层的前一个元素没有在路径中
            // 因为是i -> length顺序遍历的, 如果前一个元素没有在路径中, 说明在之前的dfs中已经遍历过了, 此次不需要重复进行dfs, 剪枝
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, depth + 1, path, used, res);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
        System.out.println(permuteUnique(new int[]{1, 2, 3}));
    }
}
