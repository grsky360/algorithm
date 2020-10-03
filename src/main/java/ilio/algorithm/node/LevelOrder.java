package ilio.algorithm.node;

import ilio.algorithm.data.TreeNode;

import java.util.*;

/**
 * @Author hyia
 * @Date   2020/10/03 09:43
 * @url https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class LevelOrder {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res.add(new ArrayList<>());

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                res.get(res.size() - 1).add(node.val);
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

}
