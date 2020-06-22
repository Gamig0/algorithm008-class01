package week09code;

import java.util.HashSet;

/**
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-18 10:09
 */
public class JewelsAndStones {

    /**
     * 方法一：HashSet + 计数器
     * 使用 HashSet 保存 J 字符串中的字符，
     * 遍历 S 字符串，统计 HashSet 中包含的字符。
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> hs = new HashSet<>();
        char[] j = J.toCharArray();
        for (char i : j) {
            hs.add(i);
        }
        char[] s = S.toCharArray();
        int count = 0;
        for (char i : s) {
            if (hs.contains(i)) {
                count++;
            }
        }
        return count;
    }
}
