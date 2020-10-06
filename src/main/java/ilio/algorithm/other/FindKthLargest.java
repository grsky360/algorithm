package ilio.algorithm.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author hyia
 * @Date 2020/10/06 21:56
 */
public class FindKthLargest {

    public static int findKthLargest(int[] nums, int k) {
        List<Integer> res = new ArrayList<>(k);
        for (int num : nums) {
            put(res, k, num);
        }
        return res.get(0);
    }

    private static void put(List<Integer> list, int k, int val) {
        if (list.size() == k) {
            if (list.get(0) >= val) {
                return;
            }
            list.set(0, val);
            adjust(list, 0);
            return;
        }
        list.add(val);
        int child = list.size() - 1;
        int parent = (child - 1) >> 1;
        while (child > 0 && list.get(parent) > list.get(child)) {
            int tmp = list.get(parent);
            list.set(parent, list.get(child));
            list.set(child, tmp);
            child = parent;
            parent = (child - 1) >> 1;
        }
    }

    private static void adjust(List<Integer> list, int parent) {
        int child = (parent << 1) + 1;
        int temp = list.get(parent);
        while (child < list.size()) {
            if (child + 1 < list.size() && list.get(child) > list.get(child + 1)) {
                child++;
            }
            if (temp < list.get(child)) {
                break;
            }
            list.set(parent, list.get(child));
            parent = child;
            child = (child << 1) + 1;
        }
        list.set(parent, temp);
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)); // 5
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // 4
        System.out.println(findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 5)); // 3
    }
}
