package week09code;

/**
 * 746. 使用最小花费爬楼梯
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-15 14:42
 */
public class MinCostClimbingStairs {

    /**
     * emm
     * 时间复杂度：O(n)
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int a = 0, b = 0, current = 0;
        for (int i = 0; i < cost.length; ++i) {
            current = cost[i] + (a < b ? a : b);
            a = b;
            b = current;
        }
        return a < b ? a : b;
    }
}
