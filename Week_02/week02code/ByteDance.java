package week02code;

import java.util.Scanner;


/**
 * 一道字节跳动的面试题：万万没想到之聪明的编辑
 * https://www.nowcoder.com/profile/488577982/test/33015793/362290
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-26 19:35
 */
public class ByteDance {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.valueOf(sc.nextLine());
        String[] s = new String[num];
        for (int i = 0; i < num; ++i) {
            s[i] = sc.nextLine();
            System.out.println(changeWord(s[i]).trim());
        }
    }

    public static String changeWord(String s) {
        if (s.length() < 3) return s;
        char[] result = new char[s.length()];
        result[0] = s.charAt(0);
        result[1] = s.charAt(1);
        int j = 2;
        for (int i = 2; i < result.length; ++i) {
            if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i - 1) == s.charAt(i - 2)) {
                continue;
            }
            if (i > 2 && s.charAt(i) == s.charAt(i - 1) && s.charAt(i - 2) == s.charAt(i - 3)) {
                continue;
            }
            result[j++] = s.charAt(i);
        }
        return new String(result);
    }
}
