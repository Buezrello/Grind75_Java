package grind75.setallvalues;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Create a map that addition to put and get has a method setAllValues with O(1)
 */

public class CustomHashMap<K, V> {
    private final HashMap<K, V> map;
    private V globalValue;
    private final Set<K> globalKeySet;

    public CustomHashMap() {
        map = new HashMap<>();
        globalValue = null;
        globalKeySet = new HashSet<>();
    }

    public V get(K key) {

        if (globalKeySet.contains(key)) {
            return globalValue;
        }

        return map.get(key);
    }

    public void put(K key, V value) {
        map.put(key, value);
        globalKeySet.remove(key);
    }

    public void setAllValues(V value) {
        globalValue = value;
        globalKeySet.addAll(map.keySet());
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> customHashMap = new CustomHashMap<>();

        customHashMap.put("one", 1);
        customHashMap.put("two", 2);
        customHashMap.put("three", 3);

        System.out.println("output for key one: " + customHashMap.get("one"));
        System.out.println("output for key two: " + customHashMap.get("two"));
        System.out.println("output for key three: " + customHashMap.get("three"));
        System.out.println();

        customHashMap.setAllValues(999);
        System.out.println("output for key one: " + customHashMap.get("one"));
        System.out.println("output for key two: " + customHashMap.get("two"));
        System.out.println("output for key three: " + customHashMap.get("three"));
        System.out.println();

        customHashMap.put("two", 22);
        System.out.println("output for key one: " + customHashMap.get("one"));
        System.out.println("output for key two: " + customHashMap.get("two"));
        System.out.println("output for key three: " + customHashMap.get("three"));
        System.out.println();

        customHashMap.put("four", 4);
        System.out.println("output for key one: " + customHashMap.get("one"));
        System.out.println("output for key two: " + customHashMap.get("two"));
        System.out.println("output for key three: " + customHashMap.get("three"));
        System.out.println("output for key four: " + customHashMap.get("four"));
        System.out.println();

        customHashMap.setAllValues(888);
        System.out.println("output for key one: " + customHashMap.get("one"));
        System.out.println("output for key two: " + customHashMap.get("two"));
        System.out.println("output for key three: " + customHashMap.get("three"));
        System.out.println("output for key four: " + customHashMap.get("four"));
    }

}
