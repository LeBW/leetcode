import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 * 双向链表的插入删除等
 * @author LBW
 */
public class LRUCache {
    class LinkedNode {
        int key;
        int val;
        LinkedNode prev;
        LinkedNode next;

        public LinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private LinkedNode head;
    private LinkedNode tail;
    private Map<Integer, LinkedNode> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.head = new LinkedNode(-1, -1);
        this.tail = new LinkedNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // put cur to the head if cur is not the head.
        LinkedNode cur = map.get(key);
        if (head.next != cur) {
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;

            cur.next = head.next;
            cur.prev = head;
            head.next.prev = cur;
            head.next = cur;
        }

        return cur.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            LinkedNode cur = map.get(key);
            cur.val = value;
            // put cur to the head if cur is not the head.
            if (head.next != cur) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;

                cur.next = head.next;
                cur.prev = head;
                head.next.prev = cur;
                head.next = cur;
            }
        }
        else {
            if (map.size() == capacity) {
                // remove the last one
                LinkedNode tobeRemove = tail.prev;
                map.remove(tobeRemove.key);
                tobeRemove.prev.next = tail;
                tail.prev = tobeRemove.prev;
            }
            // add cur to the head
            LinkedNode cur = new LinkedNode(key, value);
            map.put(key, cur);

            cur.next = head.next;
            cur.prev = head;
            head.next.prev = cur;
            head.next = cur;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }
}
