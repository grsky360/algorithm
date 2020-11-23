package ilio.algorithm.node;

import ilio.algorithm.data.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author hyia
 * @url
 */
public class ValidBST {

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode pre = null;
        while (!deque.isEmpty() || root != null) {
            while (root != null) {
                deque.offerLast(root);
                root = root.left;
            }
            root = deque.pollLast();
            if (pre != null && root.val < pre.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidBST(
            new TreeNode(2, new TreeNode(1), new TreeNode(3))
        ));
        System.out.println(isValidBST(
            new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4,
                    new TreeNode(3),
                    new TreeNode(6)))
        ));
    }
}
