package ilio.algorithm.node;

import ilio.algorithm.data.TreeNode;

import java.util.*;

/**
 * @Author hyia
 * @Date 2020/10/03 14:11
 * @url https://leetcode-cn.com/problems/binary-tree-right-side-view
 */
public class RightSideView {

    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.remove();
                if (i == length - 1) {
                    res.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(rightSideView(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)))));
    }
}
