package ilio.algorithm.node;

import ilio.algorithm.data.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author hyia
 * @Date 2020/10/06 20:15
 */
public class BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(res, root, "");
        return res;
    }

    private static void dfs(List<String> res, TreeNode root, String str) {
        if (root == null) {
            return;
        }
        StringBuilder builder = new StringBuilder(str);
        builder.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(builder.toString());
        } else {
            builder.append("->");
            dfs(res, root.left, builder.toString());
            dfs(res, root.right, builder.toString());
        }
    }

    public static void main(String[] args) {
        System.out.println(binaryTreePaths(
            new TreeNode(1,
                new TreeNode(2,
                    null,
                    new TreeNode(5)),
                new TreeNode(3))
        ));
    }

}
