import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 116. 117.  Populating Next Right Pointers in Each Node
 * 层序遍历
 * @author LBW
 */
public class PopulatingNextRightPointers {
    public Node connect(Node root) {
        Deque<Node> queue = new ArrayDeque<>();
        if (root != null)
            queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
                if (i < size - 1)
                    cur.next = queue.peek();
                else
                    cur.next = null;  //the last element in the level.
            }
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
