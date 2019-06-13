package leetcode.sort;

public class MedianSortedArrays {
    public double findMediaSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int[] array = new int[total];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                array[k++] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                array[k++] = nums2[j++];
            } else {
                array[k++] = nums1[i++];
                array[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            array[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            array[k++] = nums2[j++];
        }
        if (array.length % 2 == 0) {
            return (array[array.length / 2] + array[array.length / 2 - 1]) / 2.0;
        }
        return (double) array[array.length / 2];
    }

    public static void main(String[] args) {
        MedianSortedArrays median = new MedianSortedArrays();
        int[] a = new int[] { 2, 4, 5, 8 };
        int[] b = new int[] { 4, 5, 7 };
        System.out.println(median.findMediaSortedArrays(a, b));
    }
}