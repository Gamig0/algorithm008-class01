package week01code;

/**
 * 11.盛最多水的容器
 * @author Gamigo
 * @date 2020-04-13 15:16
 * @version 1.0
 */
public class ContainerWithMostWater {

    /**
     * 方法二：双指针
     * 两指针分别从数组首尾向中间遍历，每次移动数值较小的指针，
     * 双指针方法一定会经过最优解。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @author Gamigo
     * @date 2020-04-18 17:05
     * @param height
     * @return int
     */
    public int maxArea1(int[] height) {

        int p = 0;
        int r = height.length - 1;
        int max = 0;
        int area = 0;
        while (p < r) {
            area = (r - p) * (height[p] < height[r] ? height[p] : height[r]);
            max = max > area ? max : area;
            // 此处和area值无关，仅利用三目运算符?:简化指针移动代码
            area = height[p] < height[r] ? p++ : r--;
        }
        return max;
    }

    /**
     * 方法一：暴力求解
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @author Gamigo
     * @date 2020-04-18 17:07
     * @param height
     * @return int
     */
    public int maxArea(int[] height) {

        int length = height.length;
        int max = 0;
        int area = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                area = (j - i) * (height[i] < height[j] ? height[i] : height[j]);
                max = max > area ? max : area;
            }
        }
        return max;
    }
}
