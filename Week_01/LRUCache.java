package week01;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Gamigo
 * @Date 2020-04-14 09:50
 * @Version 1.0
 * @Description 146.LRU缓存机制
 * 单纯的看题解和调用类库完成，几乎没有理解。
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
