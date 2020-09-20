import java.beans.BeanInfo;
import java.util.HashSet;
import java.util.Set;

/**
 * 5520. Split a String Into the Max Number of Unique Substrings
 * @author LBW
 */
public class SplitStringIntoTheMaxNumberOfUniqueSubstrings {
    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        int beginIdx = 0, prev = 0, cur = 0, res = 0;
        while (beginIdx != s.length()) {
            if (!set.contains(s.substring(beginIdx, cur+1))) {
                set.add(s.substring(beginIdx, cur+1));
                prev = beginIdx;
                beginIdx = cur + 1;
                res += 1;
            }
            cur += 1;
            if (cur == s.length() && beginIdx != s.length()) {
                //回退
                cur = beginIdx - 1;
                beginIdx = prev;
                res -= 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SplitStringIntoTheMaxNumberOfUniqueSubstrings splitStringIntoTheMaxNumberOfUniqueSubstrings = new SplitStringIntoTheMaxNumberOfUniqueSubstrings();
        splitStringIntoTheMaxNumberOfUniqueSubstrings.maxUniqueSplit("ababccc");
    }
}
