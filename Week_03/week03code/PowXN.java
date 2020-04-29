package week03code;

/**
 * 50. Pow(x, n)
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-29 09:38
 */
public class PowXN {

    /**
     * 分治，把求解x^n分成求x^(n/2)
     * 时间复杂度：O(logn)
     * 空间复杂度：O(logn)
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return getResult(x, n);

    }

    public double getResult(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double subResult = getResult(x, n / 2);
        if (n % 2 != 0) {
            return subResult * subResult * x;
        } else {
            return subResult * subResult;
        }
    }

    /**
     * 这算是作弊。。。
     * @param x
     * @param n
     * @return
     */
    public double myPow0(double x, int n) {
        return Math.pow(x, n);
    }
}
