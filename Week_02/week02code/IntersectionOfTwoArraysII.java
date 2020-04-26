package week02code;

import java.util.HashMap;
import java.util.Map;

/**
 * 350. 两个数组的交集 II
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-21 13:04
 */
public class IntersectionOfTwoArraysII {

    /**
     * 方法一：使用HashMap
     * 先遍历第一个数组，将数组中元素和出现次数存储到HashMap中，
     * Key表示当前元素，Value表示元素出现次数，也是可匹配次数
     * 遍历第二个数组，如果HashMap中包含当前元素，且可匹配次数不为0
     * 则将当前元素保存
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hs = new HashMap<>();
        // 遍历第一个数组
        for (int i : nums1) {
            if (hs.containsKey(i)) {
                // 如果是重复元素，可匹配次数value+1；
                hs.put(i, hs.get(i) + 1);
            } else {
                // 首次出现的元素放入hs中
                hs.put(i, 1);
            }
        }
        // 可以创建临时数组用于保存结果，结果数组长度一定小于等于原数组中较小的，此处不做判断直接使用。
        // int[] temp = new int[nums1.length];
        // 也可以直接使用nums1数组，节省空间。
        int k = 0;
        for (int i : nums2) {
            if (hs.containsKey(i) && hs.get(i) > 0) {
                // 原数组包含当前值，并且剩余匹配次数>0
                nums1[k++] = i;
                hs.put(i, hs.get(i) - 1);
            }
        }
        int[] result = new int[k];
        /*
        for (int i = 0; i < k; ++i) {
            result[i] = temp[i];
        }
         */
        // 代替上方for循环复制数组
        System.arraycopy(nums1, 0, result, 0, k);
        return result;
    }
}
