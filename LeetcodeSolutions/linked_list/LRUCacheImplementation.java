package linked_list;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Problem 24: LRU Cache (LeetCode 146)
 * 
 * Input Format:
 * Cache capacity, then operations: get(key) or put(key, value).
 * 
 * Output Format:
 * Results of get operations.
 * 
 * Approach: HashMap + Doubly Linked List
 * 1. HashMap stores key -> node mapping for O(1) access.
 * 2. Doubly linked list maintains order (most recent at head, least recent at
 * tail).
 * 3. On get: move node to head.
 * 4. On put: add to head, remove tail if capacity exceeded.
 * 
 * Time Complexity: O(1) for both get and put.
 * Space Complexity: O(capacity)
 * 
 * Why Optimal:
 * It achieves O(1) time for all operations using the combination of HashMap and
 * DLL.
 * 
 * Edge Cases Handled:
 * - Empty cache
 * - Single element cache
 * - Capacity = 1
 * - Updating existing keys
 * - Evicting least recently used
 */

class DLLNode {
    int key;
    int value;
    DLLNode prev;
    DLLNode next;

    DLLNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    private int capacity;
    private HashMap<Integer, DLLNode> cache;
    private DLLNode head; // Most recently used
    private DLLNode tail; // Least recently used

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        // Dummy head and tail
        head = new DLLNode(0, 0);
        tail = new DLLNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        DLLNode node = cache.get(key);
        // Move to head (most recently used)
        remove(node);
        addToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Update existing key
            DLLNode node = cache.get(key);
            node.value = value;
            remove(node);
            addToHead(node);
        } else {
            // Add new key
            DLLNode newNode = new DLLNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);

            if (cache.size() > capacity) {
                // Remove least recently used (tail)
                DLLNode lru = tail.prev;
                remove(lru);
                cache.remove(lru.key);
            }
        }
    }

    private void addToHead(DLLNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(DLLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

public class LRUCacheImplementation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter cache capacity: ");
        int capacity = sc.nextInt();

        LRUCache cache = new LRUCache(capacity);

        System.out.println("Operations: 1=put, 2=get, 0=exit");
        while (true) {
            System.out.print("Enter operation: ");
            int op = sc.nextInt();

            if (op == 0)
                break;

            if (op == 1) {
                System.out.print("Enter key and value: ");
                int key = sc.nextInt();
                int value = sc.nextInt();
                cache.put(key, value);
                System.out.println("Put (" + key + ", " + value + ")");
            } else if (op == 2) {
                System.out.print("Enter key: ");
                int key = sc.nextInt();
                int result = cache.get(key);
                System.out.println("Get(" + key + ") = " + result);
            }
        }

        sc.close();
    }
}
