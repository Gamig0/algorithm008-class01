package week08code;

/**
 * 1122. 数组的相对排序@author Gamigo
 * @version 1.0
 * @date 2020-06-12 11:48
 */
public class RelativeSortArray {

    /**
     * 方法一：桶排序
     * 新建数组flag记录arr1数组元素出现次数
     * 按arr2数组元素顺序查看flag中元素出现次数并放入arr1中
     * arr2中未出现的元素放回arr1中
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] flag = new int[1001];
        for (int i : arr1) {
            flag[i]++;
        }
        int k = 0;
        for (int i : arr2) {
            while (flag[i]-- > 0) {
                arr1[k++] = i;
            }
        }
        for (int i = 0; i < 1001; ++i) {
            while(flag[i]-- > 0) {
                arr1[k++] = i;
            }
        }
        return arr1;
    }
}
