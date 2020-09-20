import java.beans.BeanInfo;
import java.util.HashSet;
import java.util.Set;

/**
 * 5520. Split a String Into the Max Number of Unique Substrings
 * 回溯法。
 * @author LBW
 */
public class SplitStringIntoTheMaxNumberOfUniqueSubstrings {
    private int res;
    private Set<String> set;
    public int maxUniqueSplit(String s) {
        res = 0;
        set = new HashSet<>();
        backTrack(s, 0);
        return res;
    }

    private void backTrack(String s, int idx) {
        if (idx == s.length()) {
            res = Math.max(res, set.size());
            return;
        }

        if (s.length() - idx + set.size() <= res)// 剪枝. 思路就是：假设当前后面所有的字符都能组成单独的字符串，如果大小还是不能超过res，就不用尝试了。
            return;
        for (int i = idx + 1; i <= s.length(); i++) {
            if (!set.contains(s.substring(idx, i))) {
                set.add(s.substring(idx, i));
                backTrack(s, i);
                set.remove(s.substring(idx, i));
            }
        }
    }

    public static void main(String[] args) {
        SplitStringIntoTheMaxNumberOfUniqueSubstrings splitStringIntoTheMaxNumberOfUniqueSubstrings = new SplitStringIntoTheMaxNumberOfUniqueSubstrings();
        splitStringIntoTheMaxNumberOfUniqueSubstrings.maxUniqueSplit("ababccc");
    }
}
