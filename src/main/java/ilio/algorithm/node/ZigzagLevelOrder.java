package ilio.algorithm.node;

import ilio.algorithm.data.TreeNode;

import java.util.*;

/**
 * @Author hyia
 * @Date 2020/10/06 20:10
 */
public class ZigzagLevelOrder {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean order = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            res.add(list);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (order) {
                    list.offerLast(node.val);
                } else {
                    list.offerFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            order = !order;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(zigzagLevelOrder(
            new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                    new TreeNode(15),
                    new TreeNode(7)))));
    }
}
