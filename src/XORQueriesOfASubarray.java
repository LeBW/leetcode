/**
 * 1310. XOR Queries of a Subarray
 * 前缀异或
 * @author LBW
 */
public class XORQueriesOfASubarray {
    /*
    方法一，使用二位数组提前存储。时间复杂度 O(n^2 + m)，空间复杂度 O(n^2 + m)。
    超出了空间复杂度，需要想办法改进。
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[][] xors = new int[n][n];
        for (int i = 0; i < n; i++) {
            xors[i][i] = arr[i];
            for (int j = i + 1; j < n; j++) {
                xors[i][j] = xors[i][j - 1] ^ arr[j];
            }
        }
        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            res[i] = xors[queries[i][0]][queries[i][1]];
        }
        return res;
    }

    /*
    方法二：前缀异或。
    利用前缀异或，提前计算出前缀异或数组 tri[n + 1]。
    然后就可以在 O(1) 的时间复杂度下计算每个query。
    所以时间复杂度 O(n + m). 空间复杂度 O(n + m).
     */
    public int[] xorQueriesTwo(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] tri = new int[n + 1];
        tri[0] = 0;
        for (int i = 1; i <= n; i++) {
            tri[i] = tri[i - 1] ^ arr[i - 1];
        }
        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            res[i] = tri[queries[i][0]] ^ tri[queries[i][1] + 1];
        }
        return res;
    }
}
