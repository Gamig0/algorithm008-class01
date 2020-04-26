package week02code;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-26 10:01
 */
public class WordPattern {

    /**
     * 使用集合存储字符和字符串对应的下标
     * 如果下标不同说明字符与字符串规律不匹配
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        Map hs = new HashMap();
        // 此处必须用Integer，未找到原因
        for (Integer i = 0; i < arr.length; ++i) {
            if (hs.put(pattern.charAt(i), i) != hs.put(arr[i], i)) {
                return false;
            }
        }
        return true;
    }
}
