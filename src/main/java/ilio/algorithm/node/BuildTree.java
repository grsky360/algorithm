package ilio.algorithm.node;

import ilio.algorithm.data.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hyia
 * @Date 2020/10/04 18:06
 * @url https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class BuildTree {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(indexMap, preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static TreeNode buildTree(Map<Integer, Integer> indexMap, int[] preOrder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preLeft]);
        int rootIdx = indexMap.get(root.val);
        int leftNum = rootIdx - inLeft;
        root.left = buildTree(indexMap, preOrder, inorder, preLeft + 1, preLeft + leftNum, inLeft, rootIdx - 1);
        root.right = buildTree(indexMap, preOrder, inorder, preLeft + leftNum + 1, preRight, rootIdx + 1, inRight);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }
}
