package week08code;

/**
 * 190. 颠倒二进制位
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-10 11:54
 */
public class ReverseBits {

    /**
     * emm。。具体方法如下，属实没看懂。。
     * @param n
     * @return
     */
    public int reverseBits1(int n) {
        return Integer.reverse(n);
    }

    public static int reverse(int i) {
        // HD, Figure 7-1
        i = (i & 0x55555555) << 1 | (i >>> 1) & 0x55555555;
        i = (i & 0x33333333) << 2 | (i >>> 2) & 0x33333333;
        i = (i & 0x0f0f0f0f) << 4 | (i >>> 4) & 0x0f0f0f0f;
        i = (i << 24) | ((i & 0xff00) << 8) |
                ((i >>> 8) & 0xff00) | (i >>> 24);
        return i;
    }
}
