package week08code.daily;

/**
 * 88. 合并两个有序数组
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-14 22:00
 */
public class MergeSortedArray {

    /**
     * 方法一：从后往前比较排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[k--] = nums1[m--];
            } else {
                nums1[k--] = nums2[n--];
            }
        }
        while (n >= 0) {
            nums1[k--] = nums2[n--];
        }
    }
}
