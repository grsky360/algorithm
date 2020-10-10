package ilio.algorithm.other;

import java.util.*;

/**
 * @Author hyia
 * @Date 2020/10/10 19:22
 * @url https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/submissions/
 */
public class MedianFinder {
    private final Queue<Integer> minHeap;
    private final Queue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        if (minHeap.size() == maxHeap.size()) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        return minHeap.size() == maxHeap.size() ? (minHeap.element() + maxHeap.peek()) / 2.0 :
            maxHeap.element();
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
        System.out.println();
    }
}
