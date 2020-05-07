package week01code;

import java.util.Stack;

/**
 * 917. 仅仅反转字母
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-18 09:44
 */
public class ReverseOnlyLetters {

    /**
     * 使用栈保存字母，第二次遍历出栈
     * 时间复杂度：O(n)    //O(2n)
     * 空间复杂度：O(n)
     * @author Gamigo
     * @date 2020-04-18 10:28
     * @param S
     * @return java.lang.String

     */
    public String reverseOnlyLetters1(String S) {
        Stack<Character> st = new Stack();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                st.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(st.pop());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 双指针前后遍历交换字母位置
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @author Gamigo
     * @date 2020-04-18 10:19
     * @param S
     * @return java.lang.String
     */
    public String reverseOnlyLetters(String S) {
        char[] s = S.toCharArray();
        int p = 0, r = s.length - 1;
        while (p < r) {
            // 可以使用!Character.isLetter(s[p])替换
            if (!(s[p] >= 'a' && s[p] <= 'z') && !(s[p] >= 'A' && s[p] <= 'Z')) {
                p++;
                continue;
            }
            else if (!(s[r] >= 'a' && s[r] <= 'z') && !(s[r] >= 'A' && s[r] <= 'Z')) {
                r--;
                continue;
            }
            else {
                s[p] ^= s[r];
                s[r] ^= s[p];
                s[p++] ^= s[r--];
            }
        }
        return new String(s);
    }

}
