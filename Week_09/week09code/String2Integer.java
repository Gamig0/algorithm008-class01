package week09code;

/**
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-21 23:00
 */
public class String2Integer {

    /**
     * 方法一：顺序遍历
     * 时间复杂度：O(n)
     * @param str
     * @return
     */
    public int myAtoi1(String str) {
        // 分别计数下标位置，符号，总数值（绝对值），字符串长度。
        int index = 0, flag = 1, total = 0, length = str.length();
        // 长度为0，直接返回。
        if (length == 0) {
            return 0;
        }
        // 顺序遍历，去到字符串前缀中所有空格。
        while (str.charAt(index) == ' ') {
            index++;
            // 如果字符串全部由空格组成，直接返回。
            if (index >= length) {
                return 0;
            }
        }
        // 查看是否由符号，并判断符号正负。
        if (str.charAt(index) == '-' || str.charAt(index) == '+') {
            // 判断符号正负。
            flag = str.charAt(index) == '-' ? -1 : 1;
            index++;
        }

        // 循环计数
        while (index < length) {
            // 记录当前一位数值
            int temp = str.charAt(index) - '0';
            // 如果不是数字，结束循环。
            if (temp < 0 || temp > 9) {
                break;
            }
            // 如果目标数的绝对值过大，返回最大或小正整数值。
            if (Integer.MAX_VALUE / 10 < total ||
                    (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < temp)) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                // 计数
                total = total * 10 + temp;
            }
            index++;
        }
        return total * flag;

    }
}
