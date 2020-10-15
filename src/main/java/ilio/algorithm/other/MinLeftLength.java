package ilio.algorithm.other;

/**
 * @Author hyia
 * @Date 2020/10/15 19:24
 * 给一个整数数组nums，将数组分成left、right两个部分，left中的所有元素都小于等于right中的所有元素，请给出最小的left子数组的长度
 * 例子1：
 * [5,0,3,8,6]
 * return 3
 * 例子2：
 * [1,1,1,0,6,12]
 * return 4
 * 3, 1, -1, -2, 7, 6, 9, 10
 * return 4
 */
public class MinLeftLength {

    public static int getMinLeftLength(int[] arr) {
        int[] rightArr = new int[arr.length];
        rightArr[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rightArr[i] = Math.min(rightArr[i + 1], arr[i]);
        }
        int leftMax = arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            int left = Math.max(leftMax, arr[i]);
            int right = rightArr[i + 1];
            if (left < right) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(getMinLeftLength(new int[]{5, 0, 3, 8, 6}));
        System.out.println(getMinLeftLength(new int[]{1, 1, 1, 0, 6, 12}));
        System.out.println(getMinLeftLength(new int[]{3, 1, -1, -2, 7, 6, 9, 10}));
    }
}
