package com.example.lru_cache;

public class LRUCacheDemo {

    public static void main(String[] args) throws InterruptedException {

        LRUCache cache = new LRUCache(2, 3);

        System.out.println("Test 1: Basic put and get");
        cache.put(1, 100);
        cache.put(2, 200);
        System.out.println("Cache: " + cache.cache);
        System.out.println(cache.get(1)); // Expected: 100
        System.out.println(cache.get(2)); // Expected: 200

        System.out.println("\nTest 2: LRU eviction");
        System.out.println("Cache: " + cache.cache);
        cache.get(1);       // Key 1 becomes recently used
        cache.put(3, 300);  // Evicts key 2
        System.out.println(cache.get(2)); // Expected: -1
        System.out.println(cache.get(3)); // Expected: 300

        System.out.println("\nTest 3: TTL expiration");
        System.out.println("Cache: " + cache.cache);
        Thread.sleep(3500);
        cache.put(1, 100);
        System.out.println(cache.get(1)); // Expected: 100
        System.out.println(cache.get(3)); // Expected: -1
        System.out.println("\nTest completed");
    }
}
