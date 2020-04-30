package week03code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-30 10:57
 */
public class LetterCombinationsPhoneNumber {

    /**
     * 方法一：递归回溯
     * 类似于括号匹配，将元素依次拼接返回最终结果
     * 时间复杂度：O(3^n * 4^m),m+n==nums.length
     * 空间复杂度：O(3^n * 4^n),结果总数
     */
    private List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return result;
        Map<Character, String> hs = new HashMap<>(10);
        hs.put('2', "abc");
        hs.put('3', "def");
        hs.put('4', "ghi");
        hs.put('5', "jkl");
        hs.put('6', "mno");
        hs.put('7', "pqrs");
        hs.put('8', "tuv");
        hs.put('9', "wxyz");
        getCombinations(digits, "", hs, 0);
        return result;
    }

    public void getCombinations(String digits, String temp,
                                Map<Character, String> hs, int n) {
        if (digits.length() == temp.length()) {
            result.add(temp);
            return;
        }
        String value = hs.get(digits.charAt(n));
        for (int i = 0; i < value.length(); ++i) {
            getCombinations(digits, temp + value.charAt(i), hs, n + 1);
        }
    }
}
