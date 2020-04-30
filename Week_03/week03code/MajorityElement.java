package week03code;

import java.util.Arrays;

/**
 * 169. 多数元素
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-30 10:54
 */
public class MajorityElement {

    /**
     * 方法一：排序计数
     * 将数组排序，计算相同元素的个数
     * 时间复杂度：O(nlogn)    // 排序算法
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1]) {
                if (count > nums.length / 2) {
                    return nums[i - 1];
                }
                count = 1;
                continue;
            }
            count++;
        }
        return nums[nums.length - 1];
    }
}
