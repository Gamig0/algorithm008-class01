package week09code;

/**
 * 58. 最后一个单词的长度
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-18 09:50
 */
public class LengthofLastWord {

    /**
     * 方法二：字符串去掉两段空格长度 - 字符串中" "字串下标值 - 1
     * 如果字符串为"" s.trim().lastIndexOf(" ")方法找不到字串返回 -1
     * @param s
     * @return
     */
    public int lengthOfLastWord2(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }

    /**
     * 方法一：先 split() 在找最后一个字符串
     * @param s
     * @return
     */
    public int lengthOfLastWord1(String s) {
        String[] arr = s.split(" ");
        if (arr.length == 0) {
            return 0;
        }
        return arr[arr.length - 1].length();
    }
}
