import java.util.HashMap;
import java.util.Map;

/**
 * 781. Rabbits in Forest
 * 偏数学吧
 * @author LBW
 */
public class RabbitsInForest {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            map.put(answers[i], map.getOrDefault(answers[i], 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int key = entry.getKey();
            res += (entry.getValue() - 1) / (key + 1) * (key + 1) + key + 1;
        }
        return res;
    }
}
