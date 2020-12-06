package ilio.algorithm.sort;

import ilio.algorithm.other.RandomArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * @author zhongqingyang
 **/
public class HeapSort extends AbstractSort {
    public HeapSort(Comparator<Integer> comparator) {
        super(comparator);
    }

    @Override
    public void sort(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }

    private void adjustHeap(int[] arr, int parent, int length) {
        int child = parent * 2 + 1;
        while (child < length) {
            if (child + 1 < length && gt(arr[child + 1], arr[child])) {
                child++;
            }
            if (lt(arr[child], arr[parent])) {
                break;
            }
            swap(arr, parent, child);
            parent = child;
            child = parent * 2 + 1;
        }
    }

    public static void main(String[] args) {
        AbstractSort sorter = new HeapSort(Comparator.reverseOrder());
        int[] arr = new RandomArray.Solution(IntStream.range(0, 30).toArray()).shuffle();
        System.out.println(Arrays.toString(arr));
        System.out.println(sorter.isSorted(arr));
        sorter.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(sorter.isSorted(arr));
    }
}
