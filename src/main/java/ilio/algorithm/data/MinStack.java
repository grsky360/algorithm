package ilio.algorithm.data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hyia
 * @Date 2020/09/25 12:23
 * @url https://leetcode-cn.com/problems/min-stack/
 */
public class MinStack {

    private final List<Integer> stack;
    private final List<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayList<>();
        this.minStack = new ArrayList<>();
        this.minStack.add(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.add(x);
        minStack.add(Math.min(top(minStack), x));
    }

    public void pop() {
//        int val = top(stack);
        pop(stack);
        pop(minStack);
    }

    public int top() {
        return top(stack);
    }

    public int getMin() {
        return top(minStack);
    }

    private static int top(List<Integer> stack) {
        return stack.get(stack.size() - 1);
    }

    private static void pop(List<Integer> stack) {
        stack.remove(stack.size() - 1);
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(5);
        obj.push(3);
        obj.push(6);
        obj.push(7);
        obj.push(1);

        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}
