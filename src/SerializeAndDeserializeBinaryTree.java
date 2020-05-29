import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 297. Serialize and Deserialize Binary Tree
 * 将二叉树进行序列化和反序列化。
 * 这里利用了层序遍历以及null进行序列化/反序列化，与LeetCode的做法比较类似
 * @author LBW
 */
public class SerializeAndDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        boolean next = true;   // 用next代表下一层是否有非空节点。（如果下一层全部为空，next为false，退出循环）
        while (next) {
            int size = deque.size();
            next = false;    //在一层的开始，首先将next置为false
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.poll();
                if (cur != null) {
                    result.add(cur.val);
                    deque.offer(cur.left);
                    deque.offer(cur.right);
                    if (cur.left != null || cur.right != null)  // 一旦发现下一层有非空节点，就把next置为true
                        next = true;
                }
                else {    //当cur为空的时候，还是要将cur加入结果数组，但是此时不用再添加其下一层节点了。
                    result.add(null);
                    //deque.add(null);
                    //deque.add(null);
                }
            }
        }
        return result.toString();
    }

    public TreeNode deserialize(String data) {
        List<TreeNode> dataList = new ArrayList<>();
        // 将 data 做预处理，得到 List<TreeNode> dataList.
        data = data.substring(1, data.length()-1);
        String[] tmp  =data.split(", ");
        for (String str: tmp) {
            if (str.equals("null"))
                dataList.add(null);
            else
                dataList.add(new TreeNode(Integer.parseInt(str)));
        }
        // dataList生成完毕后，开始生成父子关系
        int i = 0, j = 1;  // i代表当前开始寻找第i个节点的左右子节点，j代表左右子节点的index位置
        while (j < dataList.size()) {
            if (dataList.get(i) == null) {   // 如果第i个节点是空，则直接跳过（因为并没有存放它的子节点）
                i += 1;
                continue;
            }
            dataList.get(i).left = dataList.get(j++);
            dataList.get(i).right = dataList.get(j++);
            i += 1;
        }
        return dataList.get(0);
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree t = new SerializeAndDeserializeBinaryTree();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(1);
        String s = t.serialize(root);
        System.out.println(s);
        TreeNode newRoot = t.deserialize(s);
        System.out.println(newRoot);
    }
}
