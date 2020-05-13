package week04code.daily;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * @author Gamigo
 * @version 1.0
 * @date 2020-05-13 11:17
 */
public class AssignCookies {

    /**
     * 方法一：排序计数
     * 时间复杂度：O(Max(m,n))
     * 空间复杂度：O(1)
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
}
