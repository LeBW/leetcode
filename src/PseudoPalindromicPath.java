import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

/**
 * 5418. Pseudo-Palindromic Paths in a Binary Tree
 * 判断是否回文序列的条件：最多只有一种元素出现的次数为奇数。
 * @author LBW
 */
public class PseudoPalindromicPath {
    
    static class MyList extends ArrayList<Integer> {
        @Override
        public boolean add(Integer integer) {
            if (contains(integer)) {
                remove(integer);
                return true;
            }
            return super.add(integer);
        }
    }
    
    public int pseudoPalindromicPaths(TreeNode root) {
        return getCount(new MyList(), root);
    }

    private int getCount(MyList list, TreeNode root) {
        if (root == null) return 0;
    
        list.add(root.val);
    
        if (root.left == null && root.right == null) {
            return list.size() > 1 ? 0 : 1;
        } else {
            return getCount((MyList) list.clone(), root.left) + 
                   getCount((MyList) list.clone(), root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root =new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        PseudoPalindromicPath pseudoPalindromicPath =  new PseudoPalindromicPath();
        int result = pseudoPalindromicPath.pseudoPalindromicPaths(root);
        System.out.println(result);
    }
}
