package week02code;

import java.util.Stack;

/**
 * 1021. 删除最外层的括号
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-22 11:29
 */
public class RemoveOutermostParentheses {

    /**
     * 方法二：使用标识位代替栈
     * 使用标记位标记当前状态，(标记位+1，)标记位-1，
     * 如果标记位>=1则当前符号添加到结果集中
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param S
     * @return
     */
    public String removeOuterParentheses1(String S) {
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        for (char c : S.toCharArray()) {
            // 如果识别到)，标志位-1；
            if (c == ')') --flag;
            // 如果标志位>=1，将当前字符添加到结果集；
            if (flag >= 1) sb.append(c);
            // 如果识别到(，标识为+1；
            if (c == '(') ++flag;
        }
        return sb.toString();
    }

    /**
     * 方法一：栈
     * 如果栈为空(入栈，如果栈非空
     * 如果是(直接添加到结果，如果是)则先把栈中元素弹出，
     * 如果栈中元素不为空则添加到结果集。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param S
     * @return
     */
    public String removeOuterParentheses(String S) {
        Stack<Character> temp = new Stack<>();
        char[] s = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : s) {
            // 栈空入栈
            if (temp.empty()) {
                temp.push(c);
            }
            // 栈非空，识别到(，入栈并添加到结果集
            else if (c == '(') {
                temp.push(c);
                sb.append(c);
            }
            // 栈非空，识别到)，将栈等元素弹出
            else if (c == ')') {
                temp.pop();
                // 栈顶元素弹出后，如果栈非空
                // 栈非空说明当前)以及匹配的(并不是最外层的
                // 则当前符号入栈。
                if (!temp.empty()) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
