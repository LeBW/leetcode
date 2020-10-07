/**
 * 79. Word Search
 * @author LBW
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = check(board, i, j, isVisited, word, 0);
                if (flag)
                    return flag;
            }
        }
        return false;
    }

    private boolean check(char[][] board, int i, int j, boolean[][] isVisited, String word, int idx) {
        if (idx >= word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || isVisited[i][j] || word.charAt(idx) != board[i][j]) {
            return false;
        }
        isVisited[i][j] = true;
        boolean flag = false;
        if (check(board, i, j+1, isVisited, word, idx+1) || check(board, i, j-1, isVisited, word, idx+1) || check(board, i+1, j, isVisited, word, idx+1) || check(board, i-1, j, isVisited, word, idx+1)) {
            flag = true;
        }
        isVisited[i][j] = false;
        return flag;

    }
}
