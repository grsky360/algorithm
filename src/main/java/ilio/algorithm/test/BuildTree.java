package ilio.algorithm.test;

import ilio.algorithm.data.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhongqingyang
 **/
public class BuildTree {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(indexMap, preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static TreeNode buildTree(Map<Integer, Integer> inorderIndexMap, int[] preorder, int[] inorder,
                                     int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIdx = inorderIndexMap.get(root.val);
        int leftNum = rootIdx - inStart;
        root.left = buildTree(inorderIndexMap, preorder, inorder, preStart + 1, preStart + leftNum, inStart, rootIdx - 1);
        root.right = buildTree(inorderIndexMap, preorder, inorder, preStart + leftNum + 1, preEnd, rootIdx + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }
}
