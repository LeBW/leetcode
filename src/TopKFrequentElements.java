import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. Top K Frequent Elemetns
 * 哈希，优先级队列（堆）
 * 求 Top k 最大元素：用最小堆，维持k个元素
 * 求 Tok k 最小元素：用最大堆，维持k个元素
 * @author LBW
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((e1, e2) -> (e2.getValue() - e1.getValue()));
        queue.addAll(count.entrySet());
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }
}
