package week07code.daily;

import java.util.Arrays;

/**
 * 217. 存在重复元素
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-06 22:17
 */
public class ContainsDuplicate {

    /**
     * 方法一：数组排序，一次遍历
     * 时间复杂度：O(n)
     * @param nums
     * @return
     */
    public boolean containsDuplicate1(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
