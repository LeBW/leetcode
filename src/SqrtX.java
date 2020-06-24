/**
 * 69. Sqrt(x)
 * 方法一：二分查找
 * 方法二：牛顿迭代（待实现）
 * @author LBW
 */
public class SqrtX {
    public int mySqrt(int x) {
        int l = 0, r = x;
        int ans = l;
        while (l <= r) {
            int mid = (l + r) / 2;
            long square = (long)mid * mid;
            if (square == x)
                return mid;
            else if (square < x) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
