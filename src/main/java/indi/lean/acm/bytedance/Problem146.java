package indi.lean.acm.bytedance;

import java.util.LinkedHashMap;
import java.util.Map;

public class Problem146 {
}

class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> container;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.container = new LinkedHashMap<>(capacity, 1.0f, true);
    }

    public int get(int key) {
        Integer integer = container.get(key);
        return integer == null ? -1 : integer;
    }

    public void put(int key, int value) {
        if (container.size() == this.capacity) {
            Map.Entry<Integer, Integer> next = container.entrySet().iterator().next();
            container.remove(next.getKey());
        }
        container.put(key, value);
    }
}