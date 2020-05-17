package week04code;

/**
 * 69. x 的平方根
 * @author Gamigo
 * @version 1.0
 * @date 2020-05-12 12:08
 */
public class Sqrtx {

    /**
     * 方法三：国际站光头哥的代码艺术。。
     * 没看懂。。。
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }

    /**
     * 方法二：标准的二分法
     * 
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int l = 1, r = x, mid = -1;
        while (l < r) {
            mid = l + (r - l + 1) / 2;
            if ((long) mid * mid > x) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }

    /**
     * 方法一：二分查找
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     * @param x
     * @return
     */
    public int mySqrt1(int x) {
        int result = x;
        while ((long) result * result > x) {
            result /= 2;
        }
        while ((long) result * result <= x) {
            result++;
        }
        return result - 1;
    }
}
