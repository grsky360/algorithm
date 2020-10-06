package ilio.algorithm.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @Author hyia
 * @Date 2020/10/06 22:46
 */
public class Heap<T extends Comparable<T>> {

    private final boolean maxHeap;
    private final List<T> list;

    public Heap(boolean maxHeap) {
        this.maxHeap = maxHeap;
        this.list = new ArrayList<>();
    }

    public void add(T val) {
        list.add(val);
        int child = list.size() - 1;
        int parent = (child - 1) >> 1;
        while (child > 0 && ((maxHeap && lt(list.get(parent), list.get(child))) || (!maxHeap && lt(list.get(child), list.get(parent))))) {
            swap(parent, child);
            child = parent;
            parent = (child - 1) >> 1;
        }
    }

    public void addAll(Collection<T> collection) {
        for (T item : collection) {
            add(item);
        }
    }

    public T top() {
        return list.size() == 0 ? null : list.get(0);
    }

    private void adjust(int parent) {
        int child = (parent << 1) + 1;
        T temp = list.get(parent);
        while (child < list.size()) {
            if (child + 1 < list.size() && ((maxHeap && lt(list.get(child), list.get(child + 1))) || (!maxHeap && lt(list.get(child + 1), list.get(child))))) {
                child++;
            }
            if ((maxHeap && lt(list.get(child), temp)) || (!maxHeap && lt(temp, list.get(child)))) {
                break;
            }
            list.set(parent, list.get(child));
            parent = child;
            child = (child << 1) + 1;
        }
        list.set(parent, temp);
    }

    private boolean lt(T val1, T val2) {
        return val1.compareTo(val2) <= 0;
    }

    private void swap(int i, int j) {
        T tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(false);
        heap.addAll(Arrays.asList(3, 2, 1, 5, 6, 4));
        System.out.println();
        //System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)); // 5
        //System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // 4
        //System.out.println(findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 5)); // 3
    }
}
