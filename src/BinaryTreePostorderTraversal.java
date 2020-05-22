import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. Binary Tree Postorder Traversal
 * @author LBW
 */
public class BinaryTreePostorderTraversal {
    /**
     * Method 1: Recursion. 递归解法。
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode root, ArrayList<Integer> result) {
        if (root == null)
            return;
        dfs(root.left, result);
        dfs(root.right, result);
        result.add(root.val);
    }

    /**
     * Method 3: Iteration. 用一个prev来指示前一个访问的节点，从而判断是从左节点回还是从右节点回
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalTwo(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root, prev = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                prev = cur;
                cur = cur.left;
            }
            else {
                cur = stack.peek();
                if (cur.right == null || cur.right == prev) {  //从右子树回来，则可以输出根了
                    cur = stack.pop();
                    result.add(cur.val);
                    prev = cur;
                    cur = null;
                }
                else {  //从左子树回来，应该进右子树
                    prev = cur;
                    cur = cur.right;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreePostorderTraversal binaryTreePostorderTraversal = new BinaryTreePostorderTraversal();
        TreeNode root = getTreeA();
        System.out.println(binaryTreePostorderTraversal.postorderTraversalTwo(root));
    }

    static TreeNode getTreeA() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }
    static TreeNode getTreeB() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        return root;
    }
}
