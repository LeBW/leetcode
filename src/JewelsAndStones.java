import java.util.HashSet;
import java.util.Set;

/**
 * 771. Jewels and Stones
 * @author LBW
 */
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (char c: J.toCharArray()) {
            set.add(c);
        }
        int res = 0;
        for (char c: S.toCharArray()) {
            if (set.contains(c)) {
                res += 1;
            }
        }
        return res;
    }
}
