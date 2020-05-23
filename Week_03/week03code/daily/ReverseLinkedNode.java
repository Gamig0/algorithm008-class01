package week03code;

/**
 * 面试题06. 从尾到头打印链表
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-29 16:38
 */
public class ReverseLinkedNode {
    /**
     * 先将链表逆序，在打印。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        ListNode p = head;
        ListNode r = null;
        int length = 0;
        while (p != null) {
            head = head.next;
            p.next = r;
            r = p;
            p = head;
            length++;
        }
        int[] result = new int[length];
        int i = 0;
        while (r != null) {
            result[i++] = r.val;
            r = r.next;
        }
        return result;
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}