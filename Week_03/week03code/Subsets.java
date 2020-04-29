package week03code;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-29 10:04
 */
public class Subsets {

    /**
     * 回溯
     * 时间复杂度：O(n * 2^n)
     * 空间复杂度：O(n * 2^n)
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        getSubsets(result, nums, new ArrayList<Integer>(), 0);
        return result;
    }

    public void getSubsets(List<List<Integer>> result, int[] nums,
                           List<Integer> list, int index) {
        if (index == nums.length) {
            // 一定要new ArrayList();
            result.add(new ArrayList<>(list));
            return;
        }
        getSubsets(result, nums, list, index + 1);
        list.add(nums[index]);
        getSubsets(result, nums, list, index + 1);
        // backtrack
        list.remove(list.size() - 1);
    }
}
