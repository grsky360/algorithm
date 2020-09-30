package ilio.algorithm.node;

import ilio.algorithm.data.TreeNode;

/**
 * @Author hyia
 * @Date 2020/09/25 10:41
 * @url https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class CommonParentTreeNode {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        TreeNode parent = lowestCommonAncestor(root, root.left, root.right);
        System.out.println();
    }
}
