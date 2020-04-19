package week01code;

/**
 * 70.爬楼梯
 * @author Gamigo
 * @date 2020-04-15 09:01
 * @version 1.0
 */
public class ClimbingStairs {

    /**
     * 方法二：3个变量存储数据，
     * 注：题目中说明n为正整数，所以不考虑0
     * @author Gamigo
     * @date 2020-04-15 09:08
     * @param n
     * @return int
     */
    public int climbStairs1(int n) {
        if (n < 3) {
            return n == 1 ? 1 : 2;
        }

        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 2; i < n; ++i) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * 方法同上。
     */
    public int climbStairs01(int n) {
        int i = 0, j = 1, k = 1;
        while (n > 0) {
            k = i + j;
            i = j;
            j = k;
            n--;
        }
        // 题目中明确给出n为正整数
        return k;
    }

    /**
     * 方法一：数组存放数据，循环求解。
     * @author Gamigo
     * @date 2020-04-15 09:06
     * @param n
     * @return int
     */
    public int climbStairs(int n) {
        if (n < 3) {
            return n == 1 ? 1 : 2;
        }

        int[] a = new int[n];
        a[0] = 1;
        a[1] = 2;
        for (int i = 2; i < n; ++i) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n - 1];
    }

    /**
     * 方法零：纯暴力求解
     * 返回值为int所以n一定小于46，直接枚举出所有结果。。
     * 这真的是一个好方法么？
     * 小魔王回答：竞赛可以用。其余情况别用。
     * @author Gamigo
     * @date 2020-04-15 09:13
     * @param n
     * @return int
     */
    public int climbStairs0(int n) {

        int result = 0;

        switch(n){
            case 1: result = 1; break;
            case 2: result = 2; break;
            case 3: result = 3; break;
            case 4: result = 5; break;
            case 5: result = 8; break;
            case 6: result = 13; break;
            case 7: result = 21; break;
            case 8: result = 34; break;
            case 9: result = 55; break;
            case 10: result = 89; break;
            case 11: result = 144; break;
            case 12: result = 233; break;
            case 13: result = 377; break;
            case 14: result = 610; break;
            case 15: result = 987; break;
            case 16: result = 1597; break;
            case 17: result = 2584; break;
            case 18: result = 4181; break;
            case 19: result = 6765; break;
            case 20: result = 10946; break;
            case 21: result = 17711; break;
            case 22: result = 28657; break;
            case 23: result = 46368; break;
            case 24: result = 75025; break;
            case 25: result = 121393; break;
            case 26: result = 196418; break;
            case 27: result = 317811; break;
            case 28: result = 514229; break;
            case 29: result = 832040; break;
            case 30: result = 1346269; break;
            case 31: result = 2178309; break;
            case 32: result = 3524578; break;
            case 33: result = 5702887; break;
            case 34: result = 9227465; break;
            case 35: result = 14930352; break;
            case 36: result = 24157817; break;
            case 37: result = 39088169; break;
            case 38: result = 63245986; break;
            case 39: result = 102334155; break;
            case 40: result = 165580141; break;
            case 41: result = 267914296; break;
            case 42: result = 433494437; break;
            case 43: result = 701408733; break;
            case 44: result = 1134903170; break;
            case 45: result = 1836311903; break;

        }
        return result;
    }
}
