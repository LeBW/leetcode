import java.util.Arrays;

/**
 * 455. Assign Cookies
 * 贪心
 * @author LBW
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length, m = s.length;
        int sidx = 0, res = 0;
        for (int i = 0; i < n; i++) {
            while (sidx < s.length && s[sidx] < g[i]) {
                sidx += 1;
            }
            if (sidx == s.length)
                return res;
            sidx += 1;
            res += 1;
        }
        return res;
    }
}
