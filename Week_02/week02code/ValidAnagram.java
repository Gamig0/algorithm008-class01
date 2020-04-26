package week02code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-24 09:29
 */
public class ValidAnagram {

    /**
     * 方法三：字符串转数组，排序，比较字符串。
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n)   // 如果函数的参数类型为char[]，则空间复杂度为O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        char[] ca1 = s.toCharArray();
        char[] ca2 = t.toCharArray();
        Arrays.sort(ca1);
        Arrays.sort(ca2);
        return Arrays.equals(ca1, ca2);
    }

    /**
     * 方法二：使用数组保存字符串s，并计数。遍历字符串t进行匹配。
     * 时间复杂度：O(n)   // O(3n)
     * 空间复杂度：O(1)   // 不论字符串多长，temp数组长度不变。。
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        int[] temp = new int[128];
        // 遍历字符串s，存储s中出现的字符以及字符出现的次数。
        for (char c : s.toCharArray()) {
            temp[c]++;
        }
        // 遍历t，匹配t中出现的字符在s中是否出现。
        for (char c : t.toCharArray()) {
            temp[c]--;
        }
        // 如果temp数组中有非0元素，证明字符串不匹配。
        for (int i : temp) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 同方法二，细节实现不同。
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram01(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
        }
        for (int i : alphabet) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 方法一：使用hashmap存储字符串s，遍历t匹配
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        // 方法一：hashmap存储s遍历t进行匹配
        // 方法二：使用数组存储s，遍历t匹配
        char[] ca1 = s.toCharArray();
        char[] ca2 = t.toCharArray();
        if (ca1.length != ca2.length) {
            return false;
        }
        Map<Character, Integer> hs = new HashMap<>();
        for (char c : ca1) {
            if (hs.containsKey(c)) {
                hs.put(c, hs.get(c) + 1);
            } else {
                hs.put(c, 1);
            }
        }

        for (char c : ca2) {
            if (hs.containsKey(c) && hs.get(c) > 0) {
                hs.put(c, hs.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
