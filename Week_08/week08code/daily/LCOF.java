package week08code.daily;

import java.util.Arrays;

/**
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-13 22:41
 */
public class LCOF {

    /**
     * 方法二：计数排序
     * 时间复杂度：O(n)
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] tool = new int[10001];
        for (int i : arr) {
            tool[i]++;
        }
        int[] result = new int[k];
        int c = 0;
        for (int i = 0; c < k; ++i) {
            while (tool[i]-- > 0 && c < k) {
                result[c++] = i;
            }
        }
        return result;
    }

    /**
     * 方法一：工具类
     * 时间复杂度：O(nlogn)
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        Arrays.sort(arr);
        int[] result = new int[k];
        for (int i = 0; i < k; ++i) {
            result[i] = arr[i];
        }
        return result;
    }
}
