package ilio.algorithm.other;

/**
 * @Author hyia
 * @Date 2020/09/30 18:37
 * @url https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class MedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        boolean left = true;
        int length = (nums1.length + nums2.length + 1) / 2;
        while ((i + j) < length) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    i++;
                    left = true;
                } else {
                    j++;
                    left = false;
                }
            } else if (i >= nums1.length) {
                j++;
                left = false;
            } else {
                i++;
                left = true;
            }
        }
        double res = left ? nums1[i - 1] : nums2[j - 1];
        if ((nums1.length + nums2.length) % 2 == 0) {
            if (i < nums1.length && j < nums2.length) {
                res += Math.min(nums1[i], nums2[j]);
            } else if (i >= nums1.length) {
                res += nums2[j];
            } else {
                res += nums1[i];
            }
            res /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}));
        System.out.println(findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}));
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(findMedianSortedArrays(new int[]{2}, new int[]{}));
    }
}
