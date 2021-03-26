import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角。
 * 迭代
 * @author LBW
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> l = new ArrayList<>();
            List<Integer> last = res.get(res.size() - 1);
            l.add(1);
            for (int j = 0; j < last.size() - 1; j++) {
                l.add(last.get(j) + last.get(j + 1));
            }
            l.add(1);
            res.add(l);
        }
        return res;
    }
}
