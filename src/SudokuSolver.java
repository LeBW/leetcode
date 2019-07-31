import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Cell {
    char value = '.';
    ArrayList<Character> remains = new ArrayList<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
    int i, j;
    public Cell(int i, int j) {
        this.i = i;
        this.j = j;
    }
    public Cell copy() {
        Cell cell = new Cell(i, j);
        cell.value = value;
        cell.remains = new ArrayList<>();
        cell.remains.addAll(remains);
        return cell;
    }
}
class SudoKuSolver {
    public void solveSudoku(char[][] board) {
        Cell[][] cells = new Cell[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    set(cells, i, j, board[i][j]);
                }
            }
        }
        //in most case, the algorithm ends here.
        //Or we can only use backtrack（回溯）now.
        ArrayList<Cell> remains = new ArrayList<Cell>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (cells[i][j].value == '.')
                    remains.add(cells[i][j]);
            }
        }
        //sort the remains. So we can try the cell that has less possibilities first.
        remains.sort(new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.remains.size() - o2.remains.size();
            }
        });

        backTrackRemains(cells, remains, 0);
        //transfer cells.value into board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = cells[i][j].value;
            }
        }
    }

    private boolean set(Cell[][] cells, int i, int j, char c) {
        if (cells[i][j].value == c)
            return true;
        else if (cells[i][j].value != '.' || !cells[i][j].remains.contains(c))
            return false;
        int rowIndex = i / 3 * 3, columnIndex = j / 3 * 3;
        cells[i][j].value = c;
        //cells[i][j].remains.clear();
        //propagate constraints
        for (int k = 0; k < 9; k++) {
            //check row
            if (i != k) {
                if (cells[k][j].value == c)
                    return false;
                if (cells[k][j].value == '.' && cells[k][j].remains.remove(new Character(c))) {
                    if (cells[k][j].remains.size() == 1) {
                        if (!set(cells, k, j, cells[k][j].remains.get(0)))
                            return false;
                    }
                }
            }
            //check column
            if (j != k) {
                if (cells[i][k].value == c)
                    return false;
                if (cells[i][k].value == '.' && cells[i][k].remains.remove(new Character(c))) {
                    if (cells[i][k].remains.size() == 1) {
                        if (!set(cells, i, k, cells[i][k].remains.get(0)))
                            return false;
                    }
                }
            }
            //check box
            if (rowIndex + k / 3 != i || columnIndex + k % 3 != j) {
                if (cells[rowIndex + k/3][columnIndex+k%3].value == c)
                    return false;
                if (cells[rowIndex + k/3][columnIndex+k%3].value == '.' && cells[rowIndex + k/3][columnIndex+k%3].remains.remove(new Character(c))) {
                    if (cells[rowIndex + k / 3][columnIndex + k % 3].remains.size() == 1) {
                        if (!set(cells, rowIndex + k / 3, columnIndex + k % 3, cells[rowIndex + k / 3][columnIndex + k % 3].remains.get(0)))
                            return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean backTrackRemains(Cell[][] cells, ArrayList<Cell> remains, int t) {
        if (t == remains.size())
            return true;
        Cell cell = remains.get(t).copy();
        List<Character> remainChars = cell.remains;
        //Cell[][] tempCells = cells.clone();  //Used to restore cells. FAILURE!
        Cell[][] tempCells = new Cell[9][9]; //Must restore like this.
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                tempCells[i][j] = cells[i][j].copy();   //use copy() to copy the value, not the reference!
        }
        for (char c: remainChars) {
            if (set(cells, cell.i, cell.j, c)) {

                if (backTrackRemains(cells, remains, t+1)) {
                    return true;
                }

            }
            // restore cells
            /* Attention:
             * 1. We can't change cells themselves, like cells[i][j] = tempCells[i][j], because we are referring cells in ArrayList<Cell> remains.
             * 2. We can't refer field in tempCells to cells, cause it will change the value in tempCells.
             * So we can only make assignment from tempCells to cells one by one.
             */
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    cells[i][j].value = tempCells[i][j].value;
                    //cells[i][j].remains = tempCells[i][j].remains
                    cells[i][j].remains = new ArrayList<>();
                    cells[i][j].remains.addAll(tempCells[i][j].remains);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SudoKuSolver sudoKuSolver = new SudoKuSolver();
        char[][] board = {{'.','.','.','2','.','.','.','6','3'},{'3','.','.','.','.','5','4','.','1'},{'.','.','1','.','.','3','9','8','.'},{'.','.','.','.','.','.','.','9','.'},{'.','.','.','5','3','8','.','.','.'},{'.','3','.','.','.','.','.','.','.'},{'.','2','6','3','.','.','5','.','.'},{'5','.','3','7','.','.','.','.','8'},{'4','7','.','.','.','1','.','.','.'}};
        sudoKuSolver.solveSudoku(board);
        System.out.println(board);
    }
}