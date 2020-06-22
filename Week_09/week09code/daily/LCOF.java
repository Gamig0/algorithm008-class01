package week09code.daily;

/**
 * 面试题52. 两个链表的第一个公共节点
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-17 15:21
 */
public class LCOF {


    /**
     * 方法一：差值寻找
     * 比较两个链表的长度，计算链表的长度差。
     * 先让长链表移动相差的节点个数，在同时比较两链表的节点
     * 时间复杂度：O(n)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != null && b != null) {
            a = a.next;
            b = b.next;
        }
        if (a != null) {
            int countA = 0;
            while (a != null) {
                countA++;
                a = a.next;
            }
            return find(countA, headA, headB);
        } else {
            int countB = 0;
            while (b != null) {
                countB++;
                b = b.next;
            }
            return find(countB, headB, headA);
        }
    }
    private ListNode find(int count, ListNode a, ListNode b) {
        while (count != 0) {
            count--;
            a = a.next;
        }
        while (a != b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
        next = null;
    }
}
