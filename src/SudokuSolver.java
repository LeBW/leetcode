/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * @author LBW
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        backTrack(board);
    }

    //method one: backtrack
    private boolean backTrack(char[][] board) {
        for (int i = 0;i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //if the position hasn't been filled, we should try it from 1 to 9.
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        //if c is valid for the board
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;  // use c to fill the position
                            if (backTrack(board)) //and continue to fill the board
                                return true;  // we succeed to find the solution.
                            else
                                board[i][j] = '.'; //Ops, we can't find the solution by c in board[i][j], so we give it up, and continue to try the character in board[i][j]
                        }
                    }
                    return false; //After trying 1 to 9, we still can't find the solution. So we failed in this case. (Will not happen if there is any solution)
                }
            }
        }
        return true; //We traverse the board and it is full. So we return true
    }

    private boolean isValid(char[][] board, int i, int j, char c) {
        int rowIndex = i / 3 * 3, columeIndex = j / 3 * 3;  // Find two indexes. Used for cube test.
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == c || board[k][j] == c || board[rowIndex + k/3][columeIndex + k%3] == c)
                return false;
        }
        return true;
    }
}
