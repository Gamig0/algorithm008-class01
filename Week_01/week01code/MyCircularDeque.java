package week01code;

/**
 * 641. 设计循环双端队列
 * 设计思路：
 * 初始化队列时头尾指针指向同一个节点，节点值为-1
 * 插入第一个节点时，更新队列中原有节点。
 * 队列中仅剩一个节点时删除节点，将队列中的节点值置为-1，count-1。
 * @author Gamigo
 * @version 1.0
 * @date 2020-04-19 16:02
 */
public class MyCircularDeque {

    private int size;
    private int count;
    private Node frontNode;
    private Node lastNode;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.size = k;
        this.count = 0;
        Node node = new Node(-1);
        frontNode = node;
        lastNode = node;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (count == size) {
            return false;
        }
        count++;
        if (count == 1) {
            frontNode.value = value;
            return true;
        }

        Node node = new Node(value);
        frontNode.front = node;
        node.last = frontNode;
        frontNode = node;
        frontNode.front = lastNode;
        lastNode.last = frontNode;
        frontNode = node;

        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (count == size) {
            return false;
        }
        count++;
        if (count == 1) {
            lastNode.value = value;
            return true;
        }

        Node node = new Node(value);
        lastNode.last = node;
        node.front = lastNode;
        lastNode = node;
        lastNode.last = frontNode;
        frontNode.front = lastNode;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (count == 0) {
            return false;
        }
        if (count == 1) {
            frontNode.value = -1;
            count--;
            return true;
        }
        frontNode = frontNode.last;
        frontNode.front = lastNode;
        lastNode.last = frontNode;
        count--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (count == 0) {
            return false;
        }
        if (count == 1) {
            lastNode.value = -1;
            count--;
            return true;
        }
        lastNode = lastNode.front;
        lastNode.last = frontNode;
        frontNode.front = lastNode;
        count--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (count == 0) {
            return -1;
        }
        return frontNode.value;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (count == 0) {
            return -1;
        }
        return lastNode.value;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if (count == size) {
            return true;
        }
        return false;
    }
}

class Node {
    //存储值

    public int value;
    /**
     * 记录前驱节点
     */
    public Node front;
    /**
     * 记录后记节点
     */
    public Node last;


    Node(int value) {
        this.value = value;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
