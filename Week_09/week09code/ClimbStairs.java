package week09code;

/**
 * 70. 爬楼梯
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-15 10:35
 */
public class ClimbStairs {

    /**
     * 动态规划，类比硬币找零问题
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
