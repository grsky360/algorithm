package ilio.algorithm.node;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author hyia
 * @Date 2020/10/10 23:09
 * @url https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 */
public class VerifyPostorder {

    public static boolean verifyPostorder(int... postorder) {
        if (postorder.length == 0) {
            return true;
        }
        Deque<Integer> deque = new LinkedList<>();
        int parent = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            int val = postorder[i];
            if (val > parent) {
                return false;
            }
            while (!deque.isEmpty() && deque.peekLast() > val) {
                parent = deque.removeLast();
            }
            deque.offerLast(val);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(verifyPostorder(1, 6, 3, 2, 5)); // false
        System.out.println(verifyPostorder(1, 3, 2, 6, 5)); // true
        System.out.println(verifyPostorder(4, 6, 12, 8, 16, 14, 10)); // false
    }
}
