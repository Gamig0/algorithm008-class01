package week01code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15.三数之和
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-18 22:41
 */
public class SumThreeNumber {


    /**
     * 方法一：双指针    // 应该是三指针，基准指针、p指针、r指针
     * 先将数组排序，3个数中最小数大于0则直接返回结果。
     * p指针指向为剩余的最小元素，r指针指向最大元素。
     * 如果三数之和小于0，p指针右移。
     * 如果三数之和大于0，r指针左移。
     * 如果相等则继续移动p、r指针查看是否有其余的解，直至p、r指针相遇。
     * @author Gamigo
     * @date 2020-04-18 22:43
     * @param nums
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        int length = nums.length;
        // 数组长度小于3直接返回。
        if (length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; ++i) {
            // 判断基准指针是否重复
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                // p、r指针定位
                int p = i + 1;
                int r = length - 1;
                while (p < r) {
                    // 得到有效三元组
                    if (nums[i] + nums[p] + nums[r] == 0) {
                        List<Integer> temp = new ArrayList();
                        temp.add(nums[i]);
                        temp.add(nums[p]);
                        temp.add(nums[r]);
                        result.add(temp);
                        // 去重
                        while (p < r && nums[p] == nums[p + 1]) {
                            p++;
                        }
                        while (p < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        p++;
                        r--;
                    }
                    // 三数之和小于0
                    if (nums[i] + nums[p] + nums[r] < 0) {
                        while (p < r && nums[p] == nums[p + 1]) {
                            p++;
                        }
                        p++;
                    }
                    // 三数之和大于0
                    if (nums[i] + nums[p] + nums[r] > 0) {
                        while (p < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        r--;
                    }
                }
            }
        }
        return result;

    }

    /**
     * 方法一双指针优化
     * @author Gamigo
     * @date 2020-04-18 22:44
     * @param nums
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> threeSum01(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        int length = nums.length;
        if (length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; ++i) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int p = i + 1;
                int r = length - 1;
                // 简化运算
                int sum = -nums[i];
                while (p < r) {
                    if (nums[p] + nums[r] == sum) {
                        // 工具类减少代码。。但会增加时间
                        result.add(Arrays.asList(nums[i], nums[p], nums[r]));
                        // 用++替换while的{}
                        while (p < r && nums[p] == nums[++p]);
                        while (p < r && nums[r] == nums[--r]);
                    }
                    if (nums[p] + nums[r] < sum) {
                        while (p < r && nums[p] == nums[++p]);
                    }
                    if (nums[p] + nums[r] > sum) {
                        while (p < r && nums[r] == nums[--r]);
                    }
                }
            }
        }
        return result;

    }

}
