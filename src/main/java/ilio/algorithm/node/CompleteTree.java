package ilio.algorithm.node;

import ilio.algorithm.data.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author hyia
 * @Date 2020/10/03 16:23
 * @url https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
 */
public class CompleteTree {

    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode prev = root;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (prev == null && node != null) {
                return false;
            }
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
            prev = node;
        }
        return true;
    }
}
