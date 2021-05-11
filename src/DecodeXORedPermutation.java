/**
 * 1734. Decode XORed Permutation
 * 找规律的题目，主要是靠对异或的理解。
 * 首先要明确，我们只要找出 perm[0] 的值，那么剩下的值就都迎刃而解了。
 * 那么如何计算 perm[0] 的值呢？这里还是要用到异或的特点。
 * 首先定义total，从1一直异或到n，其值等于从perm[0]异或到perm[n-1].
 * 然后定义odd，从 encoded 数组中异或奇数位，即下标 1, 3, 5, ...，其值等于从 perm[1] 异或到 perm[n-1].
 * 然后就将 total ^ odd，就是 perm[0] 的值了。
 * @author LBW
 */
public class DecodeXORedPermutation {
    public int[] decode(int[] encoded) {
        int total = 0, odd = 0;
        int n = encoded.length + 1;
        for (int i = 1; i <= n; i++) {
            total ^= i;
        }
        for (int i = 1; i < encoded.length; i += 2) {
            odd ^= encoded[i];
        }
        int[] perm = new int[n];
        perm[0] = total ^ odd;
        for (int i = 1; i < n; i++) {
            perm[i] = perm[i - 1] ^ encoded[i - 1];
        }
        return perm;
    }
}
