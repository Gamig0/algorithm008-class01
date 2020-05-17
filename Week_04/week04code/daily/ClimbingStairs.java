package week04code.daily;

/**
 * 70. 爬楼梯
 * @author Gamigo
 * @version 1.0
 * @date 2020-05-17 17:32
 */
public class ClimbingStairs {

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int a = 1, b = 1, result = 1;
        for (int i = 1; i < n; ++i) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }
}
