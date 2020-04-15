package week01;

/**
 * @Author Gamigo
 * @Date 2020-04-13 16:41
 * @Version 1.0
 * @Description 283.移动零
 */
public class MoveZeroes {

    /**
     * @Author Gamigo
     * @Date 2020-04-13 16:45
     * @Param nums
     * @Return void
     * @Description 方法二：循环不变式
     */
    public void moveZeroes1(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return;
        }

        int k = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        for (int i = k; i < length; i++) {
            nums[i] = 0;
        }

    }

    /**
     * @Author Gamigo
     * @Date 2020-04-13 16:44
     * @Param nums
     * @Return void
     * @Description 方法一：双指针交换
     */
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return;
        }

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
}
