package ilio.algorithm.node;

import ilio.algorithm.data.TreeNode;

import java.util.*;

/**
 * @Author hyia
 * @url https://leetcode-cn.com/problems/path-sum-ii/
 * */
public class PathSum2 {

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            dfs(root, sum, new ArrayList<>(), res);
        }
        return res;
    }

    private static void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> res) {
        list.add(root.val);
        sum = sum - root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if (root.left != null) {
            dfs(root.left, sum, list, res);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            dfs(root.right, sum, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(pathSum(new TreeNode(5,
                new TreeNode(4,
                    new TreeNode(11,
                        new TreeNode(7),
                        new TreeNode(2))
                    , null),
                new TreeNode(8,
                    new TreeNode(13),
                    new TreeNode(4,
                        new TreeNode(5),
                        new TreeNode(1)))),
            22));
    }
}
