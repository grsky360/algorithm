package ilio.algorithm.node;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author hyia
 * @url https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * */
public class VerifyPostorder {

    public static boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        Deque<Integer> deque = new LinkedList<>();
        // 表示上一个根节点的元素，这里可以把postorder的最后一个元素root看成无穷大节点的左孩子
        int parent = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            int val = postorder[i];
            // 左子树元素必须要小于递增栈被peek访问的元素，否则就不是二叉搜索树
            if (val > parent) {
                return false;
            }
            // 数组元素小于单调栈的元素了，表示往左子树走了，记录下上个根节点
            // 找到这个左子树对应的根节点，之前右子树全部弹出，不再记录，因为不可能在往根节点的右子树走了
            while (!deque.isEmpty() && val < deque.getLast()) {
                parent = deque.pollLast();
            }
            deque.offerLast(val);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(verifyPostorder(new int[]{1, 6, 3, 2, 5})); // false
        System.out.println(verifyPostorder(new int[]{1, 3, 2, 6, 5})); // true
        System.out.println(verifyPostorder(new int[]{4, 8, 6, 12, 16, 14, 10})); //true
    }
}
