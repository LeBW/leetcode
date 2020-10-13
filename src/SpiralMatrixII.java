/**
 * 59. Spiral Matrix II
 * @author LBW
 * 模拟题，坚持循环不变量（每一圈的每一条边都坚持左闭右开的原则，便于循环）
 * 注意最后需要单独处理n为奇数的情况。
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int x = 0, y = 0;  // 坐标
        int val = 1; // 需要赋的值
        int len = n - 1; // 每一条边里需要遍历的长度（左闭右开）
        while (len > 0) {
            //往右
            for (int i = 0; i < len; i++) {
                res[x][y++] = val++;
            }
            //往下
            for (int i = 0; i < len; i++) {
                res[x++][y] = val++;
            }
            //往左
            for (int i = 0; i < len; i++) {
                res[x][y--] = val++;
            }
            //往上
            for (int i = 0; i < len; i++) {
                res[x--][y] = val++;
            }
            // 调整x，y，len，进入下一圈
            x += 1;
            y += 1;
            len -= 2;
        }
        if (len == 0) { // 说明n是奇数，还差最后一个点
            res[x][y] = val;
        }
        return res;
    }
}
