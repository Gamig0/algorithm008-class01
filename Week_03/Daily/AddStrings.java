package week03code;

/**
 * 415.字符串相加
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-28 17:38
 */
public class AddStrings {

    /**
     * 方法一：逆序计算
     * 使用两个指针分别指向两个字符串的末尾，flag表示进位
     * 数值相加后判断是否>10,将相加后的结果%10放到结果字符串中
     * 结束循环后判断是否有最后的进位，如果有结果字符串追加1
     * 结果字符串逆序
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder("");
        // flag代表进位
        int flag = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            // 如果指针指向的字符串索引<0则当前位数值为0
            int x = i >= 0 ? num1.charAt(i--) - 48 : 0;
            int y = j >= 0 ? num2.charAt(j--) - 48 : 0;
            int temp = x + y + flag;
            // 判断进位
            flag = temp / 10;
            sb.append(temp % 10);
        }
        // 判断是否有多的进位
        if (flag == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
