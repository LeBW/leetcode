import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * @author LBW
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        //init three sets
        List<HashSet<Character>> rowSets = new ArrayList<>();
        List<HashSet<Character>> columnSets = new ArrayList<>();
        List<HashSet<Character>> boxSets = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            rowSets.add(new HashSet<>());
            columnSets.add(new HashSet<>());
            boxSets.add(new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    rowSets.get(i).add(board[i][j]);
                    columnSets.get(j).add(board[i][j]);
                    boxSets.get(i/3*3 + j/3).add(board[i][j]);
                }
            }
        }

        backTrack(board, rowSets, columnSets, boxSets);
    }

    //method one: backtrack
    private boolean backTrack(char[][] board, List<HashSet<Character>> rowSets, List<HashSet<Character>> columnSets, List<HashSet<Character>> boxSets) {
        for (int i = 0;i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //if the position hasn't been filled, we should try it from 1 to 9.
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        //if c is valid for the board
                        if (!rowSets.get(i).contains(c) && !columnSets.get(j).contains(c) && !boxSets.get(i/3*3+j/3).contains(c)) {
                            board[i][j] = c;  // use c to fill the position
                            rowSets.get(i).add(c);
                            columnSets.get(j).add(c);
                            boxSets.get(i/3*3+j/3).add(c);
                            if (backTrack(board, rowSets, columnSets, boxSets)) //and continue to fill the board
                                return true;  // we succeed to find the solution.
                            else {
                                board[i][j] = '.'; //Ops, we can't find the solution by c in board[i][j], so we give it up, and continue to try the character in board[i][j]
                                rowSets.get(i).remove(c);
                                columnSets.get(j).remove(c);
                                boxSets.get(i/3*3+j/3).remove(c);
                            }
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
