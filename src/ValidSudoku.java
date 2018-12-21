/**
 * 最重要的是，如何在i，j的递归中，将相应的board位置表达出来。
 * 1. 对于行，直接board[i][j]可以表达。
 * 2. 对于列，直接board[j][i]可以表达。
 * 3. 对于小方块，先根据i算出行和列的起点，然后根据j算出小的行和列的bias。比较复杂一点，需要理解。
 * @author LBW
 */
@SuppressWarnings("ALL")
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // init three arrays, as HashSet.
        boolean[] row = new boolean[9];
        boolean[] colume = new boolean[9];
        boolean[] cube = new boolean[9];
        //start to traverse the board.
        for (int i = 0; i < 9; i++) {
            init(row);
            init(colume);
            init(cube);
            int rowIndex = (i / 3) * 3, columeIndex = (i % 3) * 3; //used for cube judgement.
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    //judge row
                    if (!row[board[i][j] - '1']) {
                        row[board[i][j] - '1'] = true;
                    } else
                        return false;
                }
                if (board[j][i] != '.') {
                    //judge colume
                    if (!colume[board[j][i] - '1']) {
                        colume[board[j][i] - '1'] = true;
                    } else
                        return false;
                }
                if (board[rowIndex + j / 3][columeIndex + j % 3] != '.') {
                    //judge cube
                    if (!cube[board[rowIndex + j / 3][columeIndex + j % 3] - '1']) {
                        cube[board[rowIndex + j / 3][columeIndex + j % 3] - '1'] = true;
                    }
                    else
                        return false;
                }
            }
        }

        return true;
    }

    private void init(boolean[] nums) {
        for (int i = 0; i < 9; i++)
            nums[i] = false;
    }
}
