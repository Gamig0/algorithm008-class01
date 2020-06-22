package week09code.daily;

/**
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-18 22:32
 */
public class ReverseStringII {

    /**
     * leetcode 用例不通过的方法。。。。
     * 虽然边界条件没处理，但为啥leetcode用例不通过，编译器正常。。
     * @param s
     * @param k
     * @return
     */
    public static String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int c = arr.length / k;
        for (int i = 0; i < c; ++i) {
            reverseSubString(arr, k * i, k * i + k - 1);
        }
        return new String(arr);
    }

    private static void reverseSubString(char[] arr, int begin, int end) {
        while (begin < end) {
            arr[begin] ^= arr[end];
            arr[end] ^= arr[begin];
            arr[begin++] ^= arr[end--];
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseStr(s, 2));
    }
}
