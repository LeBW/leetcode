package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author LBW
 */
public class PddSecond {
    //private static int[] ji;
    //private static int[] ya;
    private static int i1;
    private static int i2;
    private static int n;
    private static int resji;
    private static int resya;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] ji = new int[n];
        int[] ya = new int[n];
        for (int i = 0; i < n; i++) {
            ji[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            ya[i] = scanner.nextInt();
        }
        i1 = 0;
        i2 = 0; // i1: ji.  i2: ya
        List<Integer> board = new ArrayList<>();
        //int idx = 0;
        resji = 0;
        resya= 0;
        while (i1 < n || i2 < n) {
            if (i1 < n) {
                jiAddToBoard(board, ji);
            }
            if (i2 < n) {
                yaAddToBoard(board, ya);
            }
        }
        for (int num: board) {
            if (num % 2 == 1) {
                resji += 1;
            }
            else {
                resya += 1;
            }
        }
        System.out.println(resji + " " + resya);
    }

    private static void yaAddToBoard(List<Integer> board, int[] ya) {
        if (!board.contains(ya[i2])) {
            board.add(ya[i2++]);
        }
        else {
            int count = 1;
            while (board.get(board.size() - 1) != ya[i2]) {
                board.remove(board.size() - 1);
                count += 1;
            }
            board.remove(board.size() - 1);
            count += 1;
            resya += count;
            i2 += 1;
            if (i2 < n) {
                yaAddToBoard(board, ya);
            }
        }
    }

    private static void jiAddToBoard(List<Integer> board, int[] ji) {
        if (!board.contains(ji[i1])) {
            board.add(ji[i1++]);
        }
        else {
            int count = 1;
            while (board.get(board.size() - 1) != ji[i1]) {
                board.remove(board.size() - 1);
                count += 1;
            }
            board.remove(board.size() - 1);
            count += 1;
            resji += count;
            i1 += 1;
            if (i1 < n) {
                jiAddToBoard(board, ji);
            }
        }
    }
}
