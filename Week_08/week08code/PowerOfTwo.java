package week08code;

/**
 * 231. 2的幂
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-10 11:52
 */
public class PowerOfTwo {

    /**
     * n & n - 1 可以直接打掉二进制的最后一个1
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
