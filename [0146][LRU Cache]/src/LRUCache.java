import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2019-06-17 17:34
 **/
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    /**
     * <pre>
     * Design and implement a data structure for Least Recently Used (LRU) cache.
     * It should support the following operations: get and put.
     *
     * get(key) - Get the value (will always be positive) of the key if the key exists
     * in the cache, otherwise return -1.
     * put(key, value) - Set or insert the value if the key is not already present. When
     * the cache reached its capacity, it should invalidate the least recently used item
     * before inserting a new item.
     *
     * The cache is initialized with a positive capacity.
     *
     * Follow up:
     * Could you do both operations in O(1) time complexity?
     *
     * Example:
     *
     * LRUCache cache = new LRUCache( 2  );// capacity
     *
     * cache.put(1,1);
     * cache.put(2,2);
     * cache.get(1);       // returns 1
     * cache.put(3,3);    // evicts key 2
     * cache.get(2);       // returns -1 (not found)
     * cache.put(4,4);    // evicts key 1
     * cache.get(1);       // returns -1 (not found)
     * cache.get(3);       // returns 3
     * cache.get(4);       // returns 4
     * </pre>
     *
     * @param capacity
     */

    private int capacity;


    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = super.get(key);
        if (value == null) {
            return -1;
        } else {
            return value;
        }
    }

    public void put(int key, int value) {
        super.put(key, value);
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
