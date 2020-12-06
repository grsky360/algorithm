package ilio.algorithm.test;

import ilio.algorithm.other.RandomArray;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author zhongqingyang
 **/
public class QuickSort {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l;
        int j = r;
        partition(arr, i, j);
        sort(arr, l, i - 1);
        sort(arr, i + 1, r);
    }

    public static int partition(int[] arr, int i, int j) {
        int key = arr[i];
        while (i < j) {
            while (i < j && arr[j] <= key) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
            }
            while (i < j && arr[i] >= key) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
            }
        }
        arr[i] = key;
        return i;
    }

    public static int topKMin(int[] arr, int k) {
        if (k <= 0 || k > arr.length) {
            return -1;
        }
        int idx = partition(arr, 0, arr.length - 1);
        while (k - 1 != idx) {
            if (k - 1 < idx) {
                idx = partition(arr, 0, idx - 1);
            } else {
                idx = partition(arr, idx + 1, arr.length - 1);
            }
        }
        return arr[idx];
    }

    public static void main(String[] args) {
        int[] arr = new RandomArray.Solution(IntStream.range(1, 30).toArray()).shuffle();
        System.out.println(Arrays.toString(arr));
        System.out.println(topKMin(arr, 6));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
