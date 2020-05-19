package week02code;

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-23 16:30
 */
public class FizzBuzz {

    /**
     * 方法二：追加字符串
     * 3的倍数追加Fizz，5的倍数追加Buzz
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * ps：空间复杂度计算的是额外消耗内存空间，返回结果不算。
     * @param n
     * @return
     */
    public List<String> fizzBuzz1(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if (sb.length() == 0) {
                sb.append(Integer.toString(i));
            }
            result.add(sb.toString());
        }
        return result;
    }
    /**
     * 方法一：暴力求解
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 1; i <= n; ++i) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }

}
