package week01;

/**
 * @Author Gamigo
 * @Date 2020-04-14 11:00
 * @Version 1.0
 * @Description 66.加一
 */
public class PlusOne {
    /**
     * @Author Gamigo
     * @Date 2020-04-14 20:02
     * @Param digits
     * @Return int[]
     * @Description 先+1，最高位进位复制到新数组。
     */
    public int[] plusOne(int[] digits) {

        int length = digits.length;
        int k = 1;
        for (int i = length - 1; i >= 0; i--) {
            digits[i] += k;
            k = (digits[i] == 10) ? 1 : 0;
            digits[i] = (k == 0) ? digits[i] : 0;
        }

        if (k == 1) {
            int[] result = new int[length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, length);
            return result;
        }
        return digits;

    }

    /**
     * @Author Gamigo
     * @Date 2020-04-14 11:16
     * @Param digits
     * @Return int[]
     * @Description 循环无进位直接返回，中途不返回新建数组设置首元素为1。
     */
    public int[] plusOne1(int[] digits) {
        // 末位+1，没有进位直接退出。
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        // 进位溢出新建数组，数组长度为原长度+1，首元素为1。
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
