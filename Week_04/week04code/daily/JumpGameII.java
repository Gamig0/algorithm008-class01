package week04code.daily;

/**
 * 45. 跳跃游戏 II
 * @author Gamigo
 * @version 1.0
 * @date 2020-05-17 17:45
 */
public class JumpGameII {

    public int jump(int[] nums) {
        int maxLength = 0, step = 0, next = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            maxLength = Math.max(maxLength, nums[i] + i);
            if (i == next) {
                next = maxLength;
                step++;
            }
        }
        return step;
    }
}
