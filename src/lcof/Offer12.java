package lcof;

/**
 * Offer12. 矩阵中的路径
 * 回溯法
 * @author LBW
 */
public class Offer12 {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (traverse(board, isVisited, i, j, word, 0))
                    return true;
                // // set isVisited to false
                // for (int k = 0; k < m; k++) {
                //     Arrays.fill(isVisited[k], false);
                // }
            }
        }
        return false;
    }

    private boolean traverse(char[][] board, boolean[][] isVisited, int i, int j, String word, int idx) {
        if (idx == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || isVisited[i][j] || board[i][j] != word.charAt(idx)) {
            return false;
        }
        isVisited[i][j] = true;
        boolean res = traverse(board, isVisited, i - 1, j, word, idx + 1) || traverse(board, isVisited, i + 1, j, word, idx + 1) || traverse(board, isVisited, i, j - 1, word, idx + 1) || traverse(board, isVisited, i, j + 1, word, idx + 1);
        isVisited[i][j] = false;
        return res;
    }
}
