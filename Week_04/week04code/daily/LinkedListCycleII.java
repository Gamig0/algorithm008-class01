package week04code.daily;

/**
 * 142. 环形链表 II
 * @author Gamigo
 * @version 1.0
 * @date 2020-05-17 17:21
 */
public class LinkedListCycleII {

    /**
     * 方法一：双指针
     * 快指针每次走两步，慢指针每次走一步
     * 如果快指针走到尽头说明链表无环，返回空
     * 如果快指针遇到慢指针，说明有环
     * 快指针总共走了 f=2s=s+n*环长度 步
     * 慢指针重新指向头节点，快慢指针都走一步，指针相遇处就是环入口
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null ) {
            return null;
        }
        ListNode f = head;
        ListNode s = head;
        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
            if (f == s) {
                break;
            }
        }
        if (f.next == null || f.next.next == null) {
            return null;
        }
        s = head;
        while (s != f) {
            s = s.next;
            f = f.next;
        }
        return s;

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
 }
