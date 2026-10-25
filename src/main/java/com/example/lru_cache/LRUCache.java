package com.example.lru_cache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    final Map<Integer, Node> cache = new HashMap<>();
    final Node head;
    final Node tail;
    final Integer capacity;

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;

        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            if (cache.size() == capacity) {
                Node lru = tail.prev;
                remove(lru);
                cache.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            addToHead(newNode);
            cache.put(key, newNode);
        } else {
            moveToHead(node);
            node.val = value;
        }
    }

    private void moveToHead(Node node) {
        remove(node);
        addToHead(node);
    }

    private void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
        node.next = null;
        node.prev = null;
    }

    private void addToHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.next = next;
        next.prev = node;
        node.prev = head;
    }
}
