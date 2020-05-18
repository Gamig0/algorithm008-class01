package week05code.daily;

/**
 * @author Gamigo
 * @version 1.0
 * @date 2020-05-18 15:45
 */
public class SearchA2DMatrix {

    /**
     * 方法一：暴力求解
     * 先找行，再找列
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(1)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 || matrix[0][0] > target) {
            return false;
        }
        int flag = -1;
        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][0] > target) {
                flag = i - 1;
                break;
            }
        }
        if (flag == -1) {
            flag = matrix.length - 1;
        }
        for (int i = 0; i < matrix[0].length; ++i) {
            if (matrix[flag][i] == target) {
                return true;
            }
        }
        return false;
    }
}
