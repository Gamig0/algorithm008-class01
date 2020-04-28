```java
package week03code;

import java.util.LinkedList;
import java.util.List;

/**
 * 22.括号生成
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-28 09:17
 */
public class Solution {

    private List<String> lists = new LinkedList<>();

    /**
     * 
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        generateP(0, 0, n, "");
        return lists;
    }

    public void generateP(int left, int right, int n, String s) {
        if (left == n && right == n) {
            lists.add(s);
        }

        if (left < n) {
            generateP(left + 1, right, n, s + "(");
        }
        if (right < left) {
            generateP(left, right + 1, n, s + ")");
        }
    }
}
```

