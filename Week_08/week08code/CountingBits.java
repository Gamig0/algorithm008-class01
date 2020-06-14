package week08code;

/**
 * 338. 比特位计数
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-10 11:55
 */
public class CountingBits {

    /**
     * 方法一：循环，分别计数。。
     * @param num
     * @return
     */
    public int[] countBits1(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
            result[i] = hammingWeight(i);
        }
        return result;
    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count ++;
            n &= (n - 1);
        }
        return count;
    }
}
