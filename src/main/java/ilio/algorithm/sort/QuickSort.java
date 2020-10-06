package ilio.algorithm.sort;

import java.util.Comparator;

/**
 * @Author hyia
 * @Date 2020/10/06 19:36
 */
public class QuickSort extends AbstractSort {

    public QuickSort(Comparator<Integer> comparator) {
        super(comparator);
    }

    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int left, int right) {
        if (left < right) {
            int i = left,
                j = right;
            int x = arr[i];
            while (i < j) {
                while (i < j && comparator.compare(x, arr[j]) <= 0) {
                    j--;
                }
                arr[i] = arr[j];
                while (i < j && comparator.compare(arr[i], x) <= 0) {
                    i++;
                }
                arr[j] = arr[i];
            }
            arr[i] = x;
            int mid = i;
            sort(arr, left, mid - 1);
            sort(arr, mid + 1, right);
        }
    }
}
