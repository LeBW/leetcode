import java.util.HashSet;
import java.util.Set;

/**
 * 357. Count Numbers with Unique Digits
 * 回溯法。dfs+剪枝
 * @author LBW
 */
public class CountNumbersWithUniqueDigits {
    private int result;

    public int countNumbersWithUniqueDigits(int n) {
        Set<Integer> set = new HashSet<>();
        result = 1;  // 先给0
        dfs(set, 0, n);
        return result;
    }

    private void dfs(Set<Integer> set, int cur, int n) {
        if (cur == n)
            return;
        if (cur == 0) {
            for (int i = 1; i <= 9; i++) {
                set.add(i);
                //System.out.println(set);
                result += 1;
                dfs(set, cur + 1, n);
                set.remove(i);
            }
        }
        else {
            for (int i = 0; i <= 9; i++) {
                if (!set.contains(i)) {
                    set.add(i);
                    //System.out.println(set);
                    result += 1;
                    dfs(set, cur + 1, n);
                    set.remove(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        CountNumbersWithUniqueDigits countNumbersWithUniqueDigits= new CountNumbersWithUniqueDigits();
        countNumbersWithUniqueDigits.countNumbersWithUniqueDigits(2);
    }
}
