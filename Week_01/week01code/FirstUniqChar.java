package week01code;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题50.第一个只出现一次的字符
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-19 09:42
 */
public class FirstUniqChar {

    /**
     * 方法二：使用数组
     * 字符值当作数组下标，数组元素存储字符出现的次数。
     * 第二次遍历找出第一个出现一次的字符。
     * 时间复杂度：O(n)    // O(2n)
     * 空间复杂度：O(n)
     * @author Gamigo
     * @date 2020-04-19 15:04
     * @param s
     * @return char
     */
    public char firstUniqChar1(String s) {
        int[] temp = new int[125];
        char[] arr = s.toCharArray();
        for (char c : arr) {
            temp[c]++;
        }
        for (char c : arr) {
            if (temp[c] == 1) {
                return c;
            }
        }
        return ' ';
    }

    /**
     * 方法一：使用HaspMap记录字符。key为字符，value表示出现次数。
     * 第一次加入value为true，否则value为false。
     * 遍历HashMap找到第一个value为true的键值对，返回key
     * 时间复杂度：O(n)    // O(2n)
     * 空间复杂度：O(n)
     * @author Gamigo
     * @date 2020-04-19 09:42
     * @param s
     * @return char
     */
    public char firstUniqChar(String s) {
        Map<Character, Boolean> hs = new HashMap();
        char[] arr = s.toCharArray();
        for (char a : arr) {
            hs.put(a, !hs.containsKey(a));
        }
        for (char a : arr) {
            if (hs.get(a)) {
                return a;
            }
        }
        return ' ';
    }
}
