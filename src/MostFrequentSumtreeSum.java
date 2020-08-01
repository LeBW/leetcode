import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LBW
 * 508. Most Frquent Sumtree Sum
 */
public class MostFrequentSumtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        postOrderTraversal(root, map);
        // find all of the highest frequency.
        int maxFreq = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int freq;
            if ((freq = entry.getValue()) > maxFreq) {
                maxFreq = freq;
            }
        }
        int[] result = new int[map.size()];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == maxFreq) {
                result[idx++] = entry.getKey();
            }
        }
        return Arrays.copyOf(result, idx);
    }

    private int postOrderTraversal(TreeNode root, Map<Integer, Integer> map) {
        if (root == null)
            return 0;
        int sum = postOrderTraversal(root.left, map) + postOrderTraversal(root.right, map) + root.val;
        if (!map.containsKey(sum)) {
            map.put(sum, 0);
        }
        map.put(sum, map.get(sum) + 1);
        return sum;
    }
}
