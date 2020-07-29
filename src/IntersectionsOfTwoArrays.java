import java.util.*;

/**
 * 349. Intersection of Two Arrays
 * @author LBW
 */
public class IntersectionsOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i: nums1) {
            set.add(i);
        }
        Set<Integer> result = new HashSet<>();
        for (int i: nums2) {
            if (set.contains(i))
                result.add(i);
        }
        // set to array
        int[] res = new int[result.size()];
        int i = 0;
        Iterator<Integer> it = result.iterator();
        while (it.hasNext()) {
            res[i++] = it.next();
        }
        return res;
    }
}
