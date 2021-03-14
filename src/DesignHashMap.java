/**
 * 706. Design HashMap
 * @author LBW
 */
public class DesignHashMap {
    final int N = 1009; // 选择一个质数，作为桶的数量
    private Node[] values;
    /** Initialize your data structure here. */
    public DesignHashMap() {
        values = new Node[N];

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = key % 1009;
        if (values[hash] == null) {
            values[hash] = new Node(key, value);
            return;
        }
        Node pre = null, cur = values[hash];
        while (cur != null && cur.key != key) {
            pre = cur;
            cur = cur.next;
        }
        if (cur == null) {
            pre.next = new Node(key, value);
        }
        else {
            cur.value = value;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = key % 1009;
        if (values[hash] == null) {
            return -1;
        }
        Node cur = values[hash];
        while (cur != null && cur.key != key) {
            cur = cur.next;
        }
        if (cur == null)
            return -1;
        return cur.value;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = key % 1009;
        if (values[hash] == null) {
            return;
        }
        Node pre = null, cur = values[hash];
        while (cur != null && cur.key != key) {
            pre = cur;
            cur = cur.next;
        }
        if (cur == null) {
            return;
        }
        if (pre != null) {
            pre.next = cur.next;
            cur.next = null;
        }
        else {
            values[hash] = cur.next;
        }

    }

    static class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
