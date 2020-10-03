package ilio.algorithm.node;

import ilio.algorithm.data.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author hyia
 * @Date 2020/10/03 20:11
 * @url https://leetcode-cn.com/problems/symmetric-tree/
 */
public class SymmetricTree {

    public static boolean isSymmetric1(TreeNode root) {
        return check1(root, root);
    }

    private static boolean check1(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            TreeNode left = queue.remove();
            TreeNode right = queue.remove();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    public static boolean isSymmetric2(TreeNode root) {
        return check2(root, root);
    }

    private static boolean check2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check2(p.left, q.right) && check2(p.right, q.left);
    }

    public static void main(String[] args) {
        System.out.println(isSymmetric1(
            new TreeNode(1,
                new TreeNode(2,
                    new TreeNode(3),
                    new TreeNode(4)),
                new TreeNode(2,
                    new TreeNode(4),
                    new TreeNode(3))
            )));
        System.out.println(isSymmetric1(
            new TreeNode(1,
                new TreeNode(2,
                    null,
                    new TreeNode(3)),
                new TreeNode(2,
                    null,
                    new TreeNode(3))
            )));
    }
}
