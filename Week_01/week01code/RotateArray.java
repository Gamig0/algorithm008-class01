package week01code;

/**
 * 189.旋转数组
 * @author Gamigo
 * @date 2020-04-15 10:54
 * @version 1.0
 */
public class RotateArray {

    /**
     * 方法一：数组三次逆序
     * @author Gamigo
     * @date 2020-04-15 10:54
     * @param nums
     * @param k
     * @return void
     */
    public void rotate(int[] nums, int k) {
        k = (k > nums.length) ? k % nums.length : k;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int p, int r) {
        while (p < r) {
            nums[p] ^= nums[r];
            nums[r] ^= nums[p];
            nums[p ++] ^= nums[r --];
        }
    }
}
