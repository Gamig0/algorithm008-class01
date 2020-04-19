package week01code;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-16 09:27
 */
public class TwoSum {

    /**
     * 方法二：使用HashMap一次遍历
     * 依次将数组元素的值和下标存放至HashMap中，
     * 查看HashMap中是否存在target-nums[i]，找到直接返回。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)    // 取决于HashMap中存放的数据量
     * @author Gamigo
     * @date 2020-04-16 09:48
     * @param nums
     * @param target
     * @return int[]
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (result.containsKey(target - nums[i])) {
                return new int[] {result.get(target - nums[i]), i};
            }
            result.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 依次遍历所有可能，暴力求解。
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @author Gamigo
     * @date 2020-04-16 09:27
     * @param nums
     * @param target
     * @return int[]
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (target == nums[i] + nums[j]) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
