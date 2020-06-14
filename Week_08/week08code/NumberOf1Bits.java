package week08code;

/**
 * 191. 位1的个数
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-09 21:21
 */
public class NumberOf1Bits {

    /**
     * 方法二：使用 n&n-1 方法打掉二进制n的最后一个1
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count ++;
            n &= (n - 1);
        }
        return count;
    }

    /**
     * 方法一改良
     * you need to treat n as an unsigned value
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        // n is unsigned
        return count;
    }

    /**
     * 方法一：暴力求解
     * @param n
     * @return
     */
    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        // n is unsigned
        return count;
    }
}
