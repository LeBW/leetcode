import java.util.HashMap;
import java.util.Map;

/**
 * 437. Path Sum III
 * 前缀和，哈希表。
 * 前缀和，加上哈希表，可以在 O（n）时间复杂度内解决这个问题。
 * 主要思路：
 * 对二叉树进行回溯DFS，用哈希表存储当前路径上的前缀和，以及该前缀和出现的次数。
 * 对于当前节点 cur，只需要拿到 cur - targetSum 在哈希表中出现的次数，就可以以 cur 为尾节点的符合条件的路径数目。
 * @author LBW
 */
public class PathSumIII {
    private int res;

    public int pathSum(TreeNode root, int targetSum) {
        res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 这里主要是满足从根节点开始的路径为 targetSum 的情况
        backTrack(root, 0, map, targetSum);
        return res;
    }

    private void backTrack(TreeNode root, int sum, Map<Integer, Integer> map, int targetSum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        res += map.getOrDefault(sum - targetSum, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        backTrack(root.left, sum, map, targetSum);
        backTrack(root.right, sum, map, targetSum);
        map.put(sum, map.getOrDefault(sum, 0) - 1);
    }
}
