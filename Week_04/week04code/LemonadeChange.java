package week04code;

/**
 * 860. 柠檬水找零
 * @author Gamigo
 * @version 1.0
 * @date 2020-05-12 12:10
 */
public class LemonadeChange {

    public boolean lemonadeChange2(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) {five--; ten++;}
            else if (ten > 0) {ten--; five--;}
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }

    /**
     * 方法一：暴力求解
     * 因为只有面值为5，10，20的钱
     * 所以只需要记录面值为5和10的个数
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param bills
     * @return
     */
    public boolean lemonadeChange1(int[] bills) {
        int[] coins = new int[2];
        for (int i = 0; i < bills.length; ++i) {
            if (bills[i] == 20) {
                if ((coins[0] >= 1 && coins[1] >= 1) || coins[0] >= 3) {
                    if (coins[1] >= 1) {
                        coins[0]--;
                        coins[1]--;
                    } else {
                        coins[0] -= 3;
                    }
                } else {
                    return false;
                }
            } else if (bills[i] == 10) {
                if (coins[0] >= 1) {
                    coins[0]--;
                    coins[1]++;
                } else {
                    return false;
                }
            } else {
                coins[0]++;
            }
        }
        return true;
    }
}
