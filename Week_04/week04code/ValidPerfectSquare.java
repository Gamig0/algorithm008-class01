package week04code;

/**
 * 367. 有效的完全平方数
 * @author Gamigo
 * @version 1.0
 * @date 2020-05-13 11:06
 */
public class ValidPerfectSquare {

    /**
     * 方法一：二分查找
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     * @param num
     * @return
     */
    public boolean isPerfectSquare1(int num) {
        if (num == 1) {
            return true;
        }
        int l = 1, r = num;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if ((long) mid * mid > num) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        // 不加强转测试数据808201会出错。。
        return ((long) l * l == num) ? true : false;
    }

}
