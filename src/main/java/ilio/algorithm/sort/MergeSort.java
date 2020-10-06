package ilio.algorithm.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author hyia
 * @Date 2020/10/06 19:19
 */
public class MergeSort extends AbstractSort {

    public MergeSort(Comparator<Integer> comparator) {
        super(comparator);
    }

    @Override
    public void sort(int[] arr) {
        int[] tmp = new int[arr.length];
        sort(arr, tmp, 0, arr.length - 1);
    }

    private void sort(int[] arr, int[] tmp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        int l1 = left;
        int l2 = mid + 1;
        sort(arr, tmp, l1, mid);
        sort(arr, tmp, l2, right);

        int index = left;
        while (l1 <= mid && l2 <= right) {
            if (comparator.compare(arr[l1], arr[l2]) < 0) {
                tmp[index++] = arr[l1++];
            } else {
                tmp[index++] = arr[l2++];
            }
        }
        while (l1 <= mid) {
            tmp[index++] = arr[l1++];
        }
        while (l2 <= right) {
            tmp[index++] = arr[l2++];
        }
        System.arraycopy(tmp, left, arr, left, right + 1 - left);
    }

}
