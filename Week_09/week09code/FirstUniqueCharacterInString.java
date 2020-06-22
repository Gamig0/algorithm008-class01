package week09code;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-21 09:58
 */
public class FirstUniqueCharacterInString {

    /**
     * 方法二：使用数组替代 HashMap 计数
     * @param s
     * @return
     */
    public int firstUniqChar2(String s) {
        char[] arr = s.toCharArray();
        int[] count = new int[26];
        for (char c : arr) {
            count[c - 'a']++;
        }
        for (int i = 0; i < arr.length; ++i) {
            if (count[arr[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 方法一：使用HashMap
     * 遍历字符串，将字符及出现次数保存到 HashMap 中
     * 二次遍历字符串，找出第一个只出现一次的字符
     * 时间复杂滴：O(n)
     * @param s
     * @return
     */
    public int firstUniqChar1(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> hs = new HashMap<>();
        for (char c : arr) {
            if (hs.containsKey(c)) {
                hs.put(c, hs.get(c) + 1);
            } else {
                hs.put(c, 1);
            }
        }
        for (int i = 0; i < arr.length; ++i) {
            if (hs.get(arr[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
