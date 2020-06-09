package week07code.daily;

import java.util.HashMap;

/**
 *
 * 350. 两个数组的交集 II
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-06 22:19
 */
public class IntersectionOfTwoArraysII {

    /**
     * 方法一：使用HashMap集合
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        // 两个数组交集一定不会超过较短数组的长度
        if (nums1.length > nums2.length) {
            return intersect1(nums2, nums1);
        }
        HashMap<Integer, Integer> hs = new HashMap<>();
        // 将较短元素存放到HashMap集合中
        for (int i : nums1) {
            if (hs.containsKey(i)) {
                hs.put(i, hs.get(i) + 1);
            } else {
                hs.put(i, 1);
            }
        }
        // 记录数组交集元素个数
        int j = 0;
        for (int i : nums2) {
            if (hs.containsKey(i) && hs.get(i) > 0) {
                // 使用较短的数组暂存结果
                nums1[j++] = i;
                hs.put(i, hs.get(i) - 1);
            }
        }
        int[] result = new int[j];
        System.arraycopy(nums1, 0, result, 0, j);
        return result;
    }
}
