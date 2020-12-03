import java.util.Arrays;

/**
 * 204. Count Primes
 * @author LBW
 */
public class CountPrimes {
    /**
     * 方法一，暴力法，不通过。
     */
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i))
                count += 1;
        }
        return count;
    }

    private boolean isPrime(int n) {
        if (n == 2 || n == 3)
            return true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    /**
     * 方法二：埃式筛。基本思路：每次遇到质数时，将其倍数全部标记为合数
     */
    public int countPrimesTwo(int n) {
        if (n < 3)
            return 0;
        if (n < 4)  // n == 3, 此时2为质数
            return 1;
        // n >= 4.
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1); // 初始化，全部为质数
        isPrime[2] = isPrime[3] = 1;
        int res = 0;
        for(int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {  // 每次遇到质数时，将其倍数全部标记为合数
                res += 1;
                for (int k = 2; k * i < n; k++) {
                    isPrime[k*i] = 0;
                }
            }
        }
        return res;
    }
}
