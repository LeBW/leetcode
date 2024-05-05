package contest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LBW
 */
public class FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>(Arrays.asList(nums));
        int n = nums.length, cur = 0;
        while (true) {
            String s = itoa(cur, n);
            if (!set.contains(s)) {
                return s;
            }
            cur += 1;
        }
    }

    private String itoa(int cur, int n) {
        StringBuilder builder = new StringBuilder(Integer.toBinaryString(cur));
        while (builder.length() < n) {
            builder.insert(0, '0');
        }
        return builder.toString();
    }
}
