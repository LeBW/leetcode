import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 830. Positions of Large Groups
 * @author LBW
 */
public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int n = s.length();
        int begin = 0, end = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                end = i;
            }
            else {
                if (end - begin >= 2){
                    res.add(Arrays.asList(begin, end));
                }
                begin = i;
                end = i;
            }
        }
        //judge the last group
        if (end - begin >= 2) {
            res.add(Arrays.asList(begin, end));
        }
        return res;
    }
}
