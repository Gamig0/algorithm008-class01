package week02code;

/**
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-26 11:23
 */
public class SortColors {

    /**
     * 方法二：leetcode.com 上 大神解法
     * 设置三个标志位，分别记录当前0，1，2的位置。
     * 遍历数组，将标识位后移。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     */
    void sortColors1(int[] nums) {
        int n0 = -1, n1 = -1, n2 = -1, n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0)
            {
                nums[++n2] = 2; nums[++n1] = 1; nums[++n0] = 0;
            }
            else if (nums[i] == 1)
            {
                nums[++n2] = 2; nums[++n1] = 1;
            }
            else if (nums[i] == 2)
            {
                nums[++n2] = 2;
            }
        }
    }

    /**
     * 方法一：指针
     * 两个指针分别指向数组两端，k指针扫描数组
     * 遇到0与i指针交换
     * 遇到2与j指针交换
     * 一次遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)   // O(3)
     * @param nums
     */
    public void sortColors(int[] nums) {
        int i = 0, j = nums.length - 1;
        for (int k = 0; k <= j; ++k) {
            if (nums[k] == 0) {
                if (k != i) {
                    nums[k] ^= nums[i];
                    nums[i] ^= nums[k];
                    nums[k--] ^= nums[i];
                }
                i++;
            } else if (nums[k] == 2) {
                if (k != j) {
                    nums[k] ^= nums[j];
                    nums[j] ^= nums[k];
                    nums[k--] ^= nums[j];
                }
                j--;
            }
        }
    }


    /**
     * 方法0：暴力求解
     * 第一次遍历记录0和1的个数
     * 第二次遍历，修改数组元素的值。
     * 时间复杂度：O(n)   // O(2n)
     * 空间复杂度：O(1)   // O(2)
     * @param nums
     */
    public void sortColors0(int[] nums) {
        int n0 = 0, n1 = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                n0++;
            } else if (nums[i] == 1) {
                n1++;
            }
        }
        for (int i = 0; i < n0; ++i) {
            nums[i] = 0;
        }
        for (int i = n0; i < n0 + n1; ++i) {
            nums[i] = 1;
        }
        for (int i = n0 + n1; i < nums.length; ++i) {
            nums[i] = 2;
        }
    }
}
