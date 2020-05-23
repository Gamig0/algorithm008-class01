package week04code.daily;

/**
 * 33. 搜索旋转排序数组
 * @author Gamigo
 * @version 1.0
 * @date 2020-05-14 23:06
 */
public class SearchInRotatedSortedArray {

    /**
     * 方法一：二分查找
     * 尽管数组是旋转过的，但从中间分开一定有一边是单调递增的
     * （只在单调区间中做判断，如果节点不在此区间则缩短另一个区间）
     * mid > left 则说明左侧单调递增，否则右侧单调递增
     *  如果目标节点 target < left 或 target > mid 则说明目标节点在另一个区间中
     * 时间复杂度：O(log(n))
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = -1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[lo]) {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
