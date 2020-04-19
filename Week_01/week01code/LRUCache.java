package week01code;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146.LRU缓存机制
 * @author Gamigo
 * @date 2020-04-14 09:50
 * @version 1.0
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    /**
     * 单纯的看题解和调用类库完成，几乎没有理解。
     * @author Gamigo
     * @date 2020-04-18 17:50
     * @param capacity
     * @return
     */
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
