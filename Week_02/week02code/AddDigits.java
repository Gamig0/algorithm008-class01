package week02code;

/**
 * 258. 各位相加
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-26 10:14
 */
public class AddDigits {

    /**
     * 方法二：数根
     * 自然数的性质
     * 知乎讲解：https://www.zhihu.com/question/30972581/answer/50203344
     * 跪了。。
     * @param num
     * @return
     */
    public int addDigits1(int num) {
        return (num - 1) % 9 + 1;
    }

    /**
     * 方法一：递归暴力求解
     * 时间复杂度：O(logn)
     * 空间复杂度：O(logn)
     * @param num
     * @return
     */
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return addDigits(sum);
    }
}
