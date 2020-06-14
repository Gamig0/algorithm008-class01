package week08code.daily;

import java.util.HashMap;

/**
 * 146. LRU缓存机制
 * @author Gamigo
 * @version 1.0
 * @date 2020-06-11 23:10
 */
public class LRUCache {

    class Node {
        int key, value;
        Node pre, next;

        public Node(){}
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int capacity;
    private HashMap<Integer, Node> cache = new HashMap<>();
    private Node first;
    private Node last;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.first = new Node();
        this.last = new Node();
        first.next = last;
        last.pre = first;
    }

    public int get(int key) {
        Node temp = cache.get(key);
        if (temp == null) {
            return -1;
        }
        removeNode(temp);
        addNode(temp);
        return temp.value;
    }

    public void put(int key, int value) {
        Node temp = cache.get(key);
        if (temp == null) {
            temp = new Node(key, value);
            cache.put(key, temp);
            addNode(temp);
            if (++size > capacity) {
                cache.remove(last.pre.key);
                removeNode(last.pre);
                size--;
            }
        } else {
            temp.value = value;
            cache.put(key, temp);
            removeNode(temp);
            addNode(temp);
        }
    }

    /**
     * 头插
     */
    public void addNode(Node node) {
        node.next = first.next;
        node.pre = first;
        first.next.pre = node;
        first.next = node;
    }

    public void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}
