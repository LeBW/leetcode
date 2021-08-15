package interview;

import java.util.*;

public class TencentFirst {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}

class LRUCache {
    private int capacity;
    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    int get(int key) {
        if (map.containsKey(key)) {
            ListNode cur = map.get(key);
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            // put cur to the head.
            cur.prev = head;
            cur.next = head.next;
            head.next.prev = cur;
            head.next = cur;

            return cur.val;
        }
        return -1;
    }

    void put(int key, int value) {
        ListNode cur;
        if (map.containsKey(key)) {
            cur = map.get(key);
            cur.val = value;
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
        }
        else {
            cur = new ListNode(key, value);
            if (map.size() == capacity) { //remove the last one
                ListNode tobeRemoved = tail.prev;
                map.remove(tobeRemoved.key);
                tobeRemoved.prev.next = tail;
                tail.prev = tobeRemoved.prev;
            }
            map.put(key, cur);
        }
        // put cur to the head
        cur.prev = head;
        cur.next = head.next;
        head.next.prev = cur;
        head.next = cur;
    }
}

class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;

    public ListNode (int key, int val) {
        this.key = key;
        this.val = val;
    }
}