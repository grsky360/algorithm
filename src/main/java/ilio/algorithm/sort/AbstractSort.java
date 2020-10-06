package ilio.algorithm.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author hyia
 * @Date 2020/10/06 19:36
 */
public abstract class AbstractSort {

    protected final Comparator<Integer> comparator;

    public AbstractSort(Comparator<Integer> comparator) {
        this.comparator = comparator;
    }

    public abstract void sort(int[] arr);

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort(Comparator.naturalOrder());
        QuickSort quickSort = new QuickSort(Comparator.reverseOrder());
        int[] arr = {1, 3, 5, 2, 9, 7, 1};
        quickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
