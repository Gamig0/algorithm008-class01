package week08code.daily;

/**
 * 1122. 数组的相对排序
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-11 22:31
 */
public class RelativeSortArray {

    /**
     * 方法一：桶排序
     * 先记录arr1数组所有元素对应出现次数
     * 遍历arr2数组，按arr2数组元素顺序查看arr1中是否存在相同元素
     * 并存放至arr1数组总
     * 遍历flag数组，将arr2中没有的元素存放到arr1中
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int[] flag = new int[1001];
        for (int value : arr1) {
            flag[value]++;
        }
        int k = 0;
        for (int value : arr2) {
            while (flag[value]-- > 0) {
                arr1[k++] = value;
            }
        }
        for (int i = 0; i < 1001; ++i) {
            while (flag[i]-- > 0) {
                arr1[k++] = i;
            }
        }
        return arr1;
    }
}
