package week09code;


/**
 * 709. 转换成小写字母
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-18 09:30
 */
public class ToLowerCase {

    /**
     * 一次遍历
     * @param str
     * @return
     */
    public String toLowerCase1(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] += 32;
            }
        }
        return new String(arr);
    }
}
