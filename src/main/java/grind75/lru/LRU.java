package grind75.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 */

public class LRU extends LinkedHashMap<Integer, Integer> {
    private final int maxSize;

    public LRU(int maxSize) {
        super(maxSize, 0.75f, true);
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > maxSize;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public static void main(String[] args) {
        LRU cache = new LRU(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1

        cache.put(3, 3);                 // evicts key 2
        System.out.println(cache.get(2)); // returns null (not found)

        cache.put(4, 4);                 // evicts key 1
        System.out.println(cache.get(1)); // returns null (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }
}
