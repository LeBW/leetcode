import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 554. Brick Wall.
 * 哈希
 * @author LBW
 */
public class BrickWall {
    /*
    我的初始思路。用 new int[width + 1] 来存储在每一个位置画竖线时的结果。
    但是超过内存使用。因为测试用例中有 [100000000]这样的大数。
    因此考虑使用哈希
     */
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        int width = 0;
        for (int i: wall.get(0)) {
            width += i;
        }
        int[] cross = new int[width + 1];
        Arrays.fill(cross, n);
        for (List<Integer> l: wall) {
            int size = l.size();
            int cur = 0;
            for (int i = 0; i < size - 1; i++) {
                cur += l.get(i);
                cross[cur] -= 1;
            }
        }
        int res = n;
        for (int i = 1; i < width; i++) {
            res = Math.min(res, cross[i]);
        }
        return res;
    }

    /*
    这里用了哈希的思想，与上面相比，减少了内存消耗。
     */
    public int leastBricksTwo(List<List<Integer>> wall) {
        int n = wall.size();
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> l: wall) {
            int size = l.size();
            int cur = 0;
            for (int i = 0; i < size - 1; i++) {
                cur += l.get(i);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
        }
        int max = 0;
        for (int value: map.values()) {
            max = Math.max(max, value);
        }
        return n - max;

    }
}
