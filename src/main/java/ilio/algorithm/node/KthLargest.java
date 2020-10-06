package ilio.algorithm.node;

import ilio.algorithm.data.TreeNode;

/**
 * @Author hyia
 * @Date 2020/10/06 21:41
 */
public class KthLargest {

    private static int res, cnt;

    public static int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    private static void dfs(TreeNode root, int k) {
        if (root.right != null) {
            dfs(root.right, k);
        }
        if (++cnt == k) {
            res = root.val;
            return;
        }
        if (root.left != null) {
            dfs(root.left, k);
        }
    }

    public static void main(String[] args) {
        System.out.println(kthLargest(
            new TreeNode(3,
                new TreeNode(1,
                    null,
                    new TreeNode(2)),
                new TreeNode(4)
            ),
            1));
        System.out.println(kthLargest(
            new TreeNode(5,
                new TreeNode(3,
                    new TreeNode(2,
                        new TreeNode(1),
                        null),
                    new TreeNode(4)),
                new TreeNode(6)
            ),
            3));
    }
}
