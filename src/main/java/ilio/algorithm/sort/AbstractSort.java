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

    public boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (gt(arr[i - 1], arr[i])) {
                return false;
            }
        }
        return true;
    }

    protected boolean lt(int o1, int o2) {
        return comparator.compare(o1, o2) < 0;
    }

    protected boolean eq(int o1, int o2) {
        return comparator.compare(o1, o2) == 0;
    }

    protected boolean gt(int o1, int o2) {
        return !eq(o1, o2) && !lt(o1, o2);
    }

    protected void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort(Comparator.naturalOrder());
        QuickSort quickSort = new QuickSort(Comparator.reverseOrder());
        int[] arr = {1, 3, 5, 2, 9, 7, 1};
        quickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
