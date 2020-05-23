import java.util.*;

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
     * Method 2: Iteration. 用一个prev来指示前一个访问的节点，从而判断是从左节点回还是从右节点回. （妈的，不能用这个方法，判断条件的地方，会死人的，下一个比较好）
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
                if (cur.right == null || cur.right == prev) {  //从右子树回来，则可以输出根了 (这一行尤其重要）
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

    /**
     * Method 3: Iteration。  利用Set来存放已经访问过的节点，比Method 2 更容易理解。
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalThree(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            //System.out.print("Iteration: ");
            if (cur != null) {
                //System.out.println("push cur: " + cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            else {
                TreeNode tmp = stack.peek();
                if (visited.contains(tmp)) {  //从右子树回来的，添加根节点，然后置cur为空，方便下次循环继续peek栈。
                    result.add(tmp.val);
                    stack.pop();  //将tmp弹出栈
                    //System.out.println("Second time visit, Add val: " + tmp.val);
                }
                else {  //从左子树回来的，要标记访问，然后接着访问右子树
                    //System.out.println("First time visit val: " + tmp.val);
                    visited.add(tmp);
                    cur = tmp.right;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreePostorderTraversal binaryTreePostorderTraversal = new BinaryTreePostorderTraversal();
        TreeNode root = getTreeA();
        System.out.println(binaryTreePostorderTraversal.postorderTraversalThree(root));
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
