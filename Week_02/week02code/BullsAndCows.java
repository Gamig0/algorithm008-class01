package week02code;

/**
 * 299. 猜数字游戏
 * Goolge面试题
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-20 10:31
 */
public class BullsAndCows {

    /**
     * 方法一代码优化
     * @param secret
     * @param guess
     * @return
     */
    public String getHint1(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); ++i) {
            // 判断位置和数值均正确
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                // 数值匹配
                if (numbers[secret.charAt(i) - '0']++ < 0) cows++;
                if (numbers[guess.charAt(i) - '0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }


    /**
     * 方法一：两次遍历求解
     * 第一次遍历计算位置和值均相同的数量，并记录不匹配元素。
     * 第二次遍历计算数值相同位置不同元素个数。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        int b = 0;
        for (int i = 0; i < s.length; ++i) {
            if (s[i] == g[i]) {
                // 记录位置和数值均正确的数量
                b++;
            } else {
                arr1[s[i] - 48]++;
                arr2[g[i] - 48]++;
            }
        }

        int c = 0;
        for (int i = 0; i < 10; ++i) {
            c += arr2[i] > arr1[i] ? arr1[i] : arr2[i];
        }

        return b + "A" + c + "B";
    }

}
