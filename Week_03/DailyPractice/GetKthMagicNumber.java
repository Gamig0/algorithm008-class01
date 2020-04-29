package week03code;

/**
 * 面试题 17.09. 第 k 个数
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-28 09:55
 */
public class GetKthMagicNumber {

    /**
     * 方法一：指针，动态规划
     * 使用三个指针指向丑数（result数组下标），
     * 比较当前指针指向的丑数 * 对应指针代表的数值
     * 得到三者当中小的新丑数，放到数组中，对应的指针+1。
     * @param k
     * @return
     */
    public int getKthMagicNumber(int k) {
        int x = 0, y = 0, z = 0;
        int[] result = new int[k];
        result[0] = 1;
        for (int i = 1; i < k; ++i) {
            result[i] = Math.min(result[x] * 3, Math.min(result[y] * 5, result[z] * 7));
            if (result[i] == result[x] * 3) x++;
            if (result[i] == result[y] * 5) y++;
            if (result[i] == result[z] * 7) z++;
        }
        return result[k - 1];
    }
}
