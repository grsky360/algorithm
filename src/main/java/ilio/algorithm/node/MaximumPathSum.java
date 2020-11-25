package ilio.algorithm.node;

import ilio.algorithm.data.TreeNode;

/**
 * @author hyia
 * @url https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 */
public class MaximumPathSum {

    public static int maxPathSum(TreeNode root) {
        int[] val = {Integer.MIN_VALUE};
        helper(root, val);
        return val[0];
    }

    private static int helper(TreeNode node, int[] val) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(helper(node.left, val), 0);
        int right = Math.max(helper(node.right, val), 0);
        val[0] = Math.max(val[0], left + right + node.val);
        return node.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        System.out.println(maxPathSum(new TreeNode(2, new TreeNode(-1), null)));
        System.out.println(maxPathSum(new TreeNode(-3)));
        System.out.println(maxPathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3)))); // 6
        System.out.println(maxPathSum(
            new TreeNode(-10,
                new TreeNode(9),
                new TreeNode(20,
                    new TreeNode(15),
                    new TreeNode(7))))); // 42
    }
}
