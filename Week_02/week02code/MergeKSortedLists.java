package week02code;

/**
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-26 12:13
 */
public class MergeKSortedLists {

    /**
     * 方法一：暴力求解
     * 循环遍历链表数组，依次合并。
     * @param lists
     * @return
     * 时间复杂度：O(n^2) // 第一根链表遍历了n次，最后一根链表遍历了1次
     * 空间复杂度：O(1)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        for (int i = 1; i < lists.length; ++i) {
            lists[i] = mergeTwoList(lists[i - 1], lists[i]);
        }
        return lists[lists.length - 1];
    }

    /**
     * 同21. 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(-1);
        ListNode result = temp;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null) {
            temp.next = l1;
        } else {
            temp.next = l2;
        }
        return result.next;
    }
}
