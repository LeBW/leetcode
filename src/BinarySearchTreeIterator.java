import java.util.ArrayList;

/**
 * 173. Binary Search Tree Iterator
 * @author LBW
 */
public class BinarySearchTreeIterator {
    private ArrayList<Integer> list;
    private int index;

    public BinarySearchTreeIterator(TreeNode root) {
        index = 0;
        list = new ArrayList<>();
        inOrderTraversal(root);
    }

    /** @return the next smallest number */
    public int next() {
        return list.get(index++);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index < list.size();
    }

    private void inOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        list.add(root.val);
        inOrderTraversal(root.right);
    }
}
