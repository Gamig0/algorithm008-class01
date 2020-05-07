package week03code.daily;

import java.util.Arrays;

/**
 * 169. 多数元素
 * @author Gamigo
 * @version 1.0
 * @date 2020-05-07 17:08
 */
public class MajorityElement {

    /**
     * 方法三：排序，一次遍历
     * 因为目标元素出现次数大于n/2，
     * 所以使用result保存当前计数器count元素，
     * 一次遍历后，计数器>0 返回当前元素。
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int result = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (count == 0) {
                count = 1;
                result = nums[i];
            } else if (result != nums[i]) {
                count--;
            } else {
                count++;
            }
        }
        return result;
    }

    /**
     * 方法二：。。。
     * 排序，因为目标元素出现次数大于n/2
     * 所以数组的最中间的元素一定是目标元素
     * 直接返回最中间的元素。。
     * 时间复杂度：O(nlogn)
     * 空间复杂度：
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 方法一：排序计数
     * 将数组排序，找出出现次数超过n/2的元素
     * 时间复杂度：O(nlogn) 排序
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
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
