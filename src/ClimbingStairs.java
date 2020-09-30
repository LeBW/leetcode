/**
 * 70. Climbing Chairs
 * @author LBW
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int prev = 1, cur = 1, next = 1;
        for (int i = 2; i <= n; i++) {
            next = prev + cur;
            prev = cur;
            cur = next;
        }
        return next;
    }
}
