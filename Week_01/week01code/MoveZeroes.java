package week01code;

/**
 * 283.移动零
 * @author Gamigo
 * @date 2020-04-13 16:41
 * @version 1.0
 */
public class MoveZeroes {


    /**
     * 方法二：循环不变式
     * 双指针指向数组开始元素，遍历数组，将数组中所有非0元素提前，
     * 依次遍历后将剩余数组元素置0。
     * 时间复杂度：O(n)    // 最坏情况是O(2n)
     * 空间复杂度：O(1)
     * @author Gamigo
     * @date 2020-04-18 17:10
     * @param nums
     * @return void
     */
    public void moveZeroes1(int[] nums) {

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        while (k < nums.length) {
            nums[k++] = 0;
        }

    }

    /**
     * 方法一：双指针交换
     * 将非零元素和数组前面的元素依次交换。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @author Gamigo
     * @date 2020-04-18 17:21
     * @param nums
     * @return void
     */
    public void moveZeroes(int[] nums) {
        int length = nums.length;

        int k = 0;
        int temp;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                temp = nums[k];
                nums[k++] = nums[i];
                nums[i] = temp;
            }
        }

    }

    /**
     * 同方法一。
     * @author Gamigo
     * @date 2020-04-18 17:27
     * @param nums
     * @return void
     */
    public void moveZeroes0(int[] nums) {
        int length = nums.length;

        int k = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    nums[k] ^= nums[i];
                    nums[i] ^= nums[k];
                    nums[k] ^= nums[i];
                }
                k++;
            }
        }

    }
}
