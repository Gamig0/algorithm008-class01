package week01code;

/**
 * 1281.整数的各位积和之差
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-16 08:41
 */
public class SubtractProductAndSum {

    /**
     * 方法一：暴力求解，循环求余数
     * @author Gamigo
     * @date 2020-04-18 18:01
     * @param n
     * @return int
     */
    public int subtractProductAndSum(int n) {
        int product = 1, sum = 0, mod;
        while (n > 0) {
            mod = n % 10;
            product *= mod;
            sum += mod;
            n /= 10;
        }
        return product - sum;
    }
}
