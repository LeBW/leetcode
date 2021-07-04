package lcof;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Offer35. 复杂链表的复制
 * 哈希。其实我这个哈希办法还不太好。
 * 更直观的是：直接用Map<Node, Node> 将旧链表中的节点与新链表中的节点进行对应，然后不管你要什么next，random也好，全部对应 map.get 即可。
 * @author LBW
 */
public class Offer35 {
    public Node copyRandomList(Node head) {
        Map<Node, Integer> map = new HashMap<>();
        List<Node> newlist = new ArrayList<>();
        Node cur = head;
        int idx = 0;
        Node dummy = new Node(-1), newcur = dummy;
        while (cur != null) {
            map.put(cur, idx++);
            newcur.next = new Node(cur.val);
            newcur = newcur.next;
            newlist.add(newcur);
            cur = cur.next;
        }
        cur = head;
        newcur = dummy.next;
        while (newcur != null) {
            if (cur.random != null) {
                newcur.random = newlist.get(map.get(cur.random));
            }
            cur = cur.next;
            newcur = newcur.next;
        }
        return dummy.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}