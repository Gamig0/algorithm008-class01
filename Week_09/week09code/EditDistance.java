package week09code;

/**
 * 72. 编辑距离
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-17 15:31
 */
public class EditDistance {

    /**
     * 方法一：二维动态规划
     * 创建二维动态规划数组dp[word1.length()][word2.length()]，
     * 记录word1或word2变换次数，列为word1，行为word2。
     * 先初始化边界 dp[0][i] 和 dp[i][0]
     * 如果 word.charAt(i) 和 word.charAt(j) 相等, dp[i][j] = dp[i - 1][j - 1];
     * 如果不等，dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1])
     *
     *   # w o r d 2
     * # 0 1 2 3 4 5
     * w 1 0 1 2 3 4
     * o 2
     * r 3
     * d 4
     * 1 5         r
     *
     * 最后返回 r位置元素
     *
     * 时间复杂度：O(m*n)
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; ++i) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= l2; ++i) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= l1; ++i) {
            for (int j = 1; j <= l2; ++j) {
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[l1][l2];
    }
}
