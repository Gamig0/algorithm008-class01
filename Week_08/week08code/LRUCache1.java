package week08code;

import java.util.HashMap;

/**
 * 146. LRU缓存机制
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-11 11:02
 */
public class LRUCache1 {

    class Node {
        int key, value;
        Node pre, next;
        public Node(){}
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public int size;
    public int capacity;
    public HashMap<Integer, Node> hs = new HashMap<Integer, Node>();
    public Node first;
    public Node last;

    public LRUCache1(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.first = new Node();
        this.last = new Node();
        this.first.next = last;
        this.last.pre = first;
    }

    public int get(int key) {
        Node temp = hs.get(key);
        if (temp == null) {
            return -1;
        }
        removeNode(temp);
        addNode(temp);
        return temp.value;
    }

    public void put(int key, int value) {
        Node temp = hs.get(key);
        if (temp == null) {
            temp = new Node(key, value);
            hs.put(key, temp);
            this.addNode(temp);
            size++;
            if (size > capacity) {
                Node n = last.pre;
                removeNode(n);
                size--;
                hs.remove(n.key);
            }
            return;
        }
        temp.value = value;
        removeNode(temp);
        addNode(temp);
    }

    public void addNode(Node node) {
        node.pre = first;
        node.next = first.next;
        first.next.pre = node;
        first.next = node;
    }

    public void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public static void main(String[] args) {
        LRUCache1 l = new LRUCache1(2);
        l.put(1, 1);
        l.put(2, 2);
        System.out.println(l.get(1));
        l.put(3, 3);
        System.out.println(l.get(2));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */