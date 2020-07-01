import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queens
 * 回溯经典算法
 * @author LBW
 */
public class NQueens {
    private List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        // init board
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        // init result
        result = new ArrayList<>();
        // start to backtrack
        backTrack(board, n, 0);
        return result;
    }

    private void backTrack(char[][] board, int n, int line) {
        // 递归结束，添加棋盘
        if (line == n) {
            result.add(toList(board, n));
            return;
        }
        // 第line行，尝试所有可选位置
        for (int i = 0; i < n; i++) {
            if (avaliable(board, n, line, i)) {
                board[line][i] = 'Q';
                backTrack(board, n, line + 1);
                board[line][i] = '.';
            }
        }
    }

    private boolean avaliable(char[][] board, int n, int l, int c) {
        // first check line and column
        for (int i = 0; i < n; i++) {
            if (board[l][i] == 'Q' || board[i][c] == 'Q')
                return false;
        }
        // then check cross line
        int i = l, j = c;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j--;
        }
        i = l + 1;
        j = c + 1;
        while (i < n && j < n) {
            if (board[i][j] == 'Q')
                return false;
            i++;
            j++;
        }
        i = l - 1;
        j = c + 1;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q')
                return false;
            i--;
            j++;
        }
        i = l + 1;
        j = c - 1;
        while (i < n && j >= 0) {
            if (board[i][j] == 'Q')
                return false;
            i++;
            j--;
        }
        return true;
    }

    private List<String> toList(char[][] board, int n) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(new String(board[i]));
        }
        return result;
    }
}
