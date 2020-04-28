package week03code;

/**
 * 239. 滑动窗口最大值
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-28 15:22
 */
public class SlidingWindowMaximum {

    /**
     * 方法一：暴力求解
     * 时间复杂度：O(n*k)
     * 空间复杂度：O(n-k+1)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; ++i) {
            result[i] = Integer.MIN_VALUE;
            for (int j = i; j < i + k; ++j) {
                result[i] = Math.max(result[i], nums[j]);
            }
        }
        return result;
    }
}
