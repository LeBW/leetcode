import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 350. Intersection of Two Arrays II
 * @author LBW
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : nums1) {
            if (!map.containsKey(value)) {
                map.put(value, 0);
            }
            map.put(value, map.get(value) + 1);
        }
        int[] result = new int[nums1.length];
        int count = 0;
        for (int value : nums2) {
            if (map.containsKey(value)) {
                result[count++] = value;
                if (map.get(value) > 1) {
                    map.put(value, map.get(value) - 1);
                } else {
                    map.remove(value);
                }
            }
        }
        // list to array
        return Arrays.copyOf(result, count);
    }
}
