import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author LBW
 * minimin-depth-of-binary-tree
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class MiniminDepthOfBinaryTree {
    public int run(TreeNode root) {
        //recursion version
//        if (root == null)
//            return 0;
//        else if (root.left != null && root.right != null) {
//            return 1 + min(run(root.left), run(root.right));
//        }
//        else {
//            return 1 + max(run(root.left), run(root.right));
//        }
        if (root == null)
            return 0;
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        arrayList.add(root);
        int depth = 0;
        //层序遍历
        while (!arrayList.isEmpty()) {
            depth += 1;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i).left == null && arrayList.get(i).right == null)
                    return depth;
                if (arrayList.get(i).left != null)
                    arrayList.add(arrayList.get(i).left);
                if (arrayList.get(i).right != null)
                    arrayList.add(arrayList.get(i).right);
            }
            for (int i = 0; i < size; i++)
                arrayList.remove(0);
        }
        return depth;
    }


}
