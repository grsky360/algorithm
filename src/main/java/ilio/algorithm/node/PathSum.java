package ilio.algorithm.node;

import ilio.algorithm.data.TreeNode;

/**
 * @Author hyia
 * @url https://leetcode-cn.com/problems/path-sum/
 * */
public class PathSum {

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null || root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) && hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {

    }
}
