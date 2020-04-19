package week01code;

import java.util.Arrays;

/**
 * 997.有序数组的平方
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-17 09:30
 */
public class SquaresOfSortedArray {

    /**
     * 方法二：双指针，分别指向数组中最后一个负数和第一个正数
     * 比较绝对值大小，计算平方和存储到新数组
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @author Gamigo
     * @date 2020-04-17 09:34
     * @param A
     * @return int[]
     */
    public int[] sortedSquares1(int[] A) {
        int length = A.length;
        // 设置初始的负数指针位置
        int q = -1;
        while (q + 1 < length && A[q + 1] < 0) {
            q++;
        }
        // 第一个正数紧跟着最后一个负数
        int p = q + 1, k = 0;
        int[] result = new int[length];
        while (q >= 0 && p < length) {
            // 比较绝对值大小
            if (-A[q] < A[p]) {
                result[k++] = A[q] * A[q];
                q--;
            } else {
                result[k++] = A[p] * A[p];
                p++;
            }
        }
        // 处理原数组中剩余的元素
        while (q >= 0 ) {
            result[k++] = A[q] * A[q];
            q--;
        }
        while (p < length) {
            result[k++] = A[p] * A[p];
            p++;
        }
        return result;
    }

    /**
     * 方法二：先求平方，再排序。
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     * @author Gamigo
     * @date 2020-04-17 09:31
     * @param A
     * @return int[]
     */
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i< A.length; ++i) {
            A[i] *= A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
