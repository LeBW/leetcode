package interview;

public class MicrosoftSecond {
    public int solution(int N, String S) {
        // write your code in Java SE 8
        S = S.replace('J', 'I');
        S = S.replace('K', 'J');

        boolean[][] matrix = new boolean[N][10];

        String[] reserved = S.split(" ");
        for (String seat: reserved) {
            if (seat == null || seat.isEmpty()) {
                continue;
            }
            matrix[seat.charAt(0) - '1'][seat.charAt(1) - 'A'] = true;
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            res += maxFamily(matrix[i]);
        }
        return res;
    }

    private int maxFamily(boolean[] row) {
        if (!row[1] && !row[2] && !row[3] && !row[4] && !row[5] && !row[6] && !row[7] && !row[8]) {
            return 2;
        }
        if ((!row[1] && !row[2] && !row[3] && !row[4]) || (!row[3] && !row[4] && !row[5] && !row[6]) || (!row[5] && !row[6] && !row[7] && !row[8])) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        MicrosoftSecond microsoftSecond = new MicrosoftSecond();
        System.out.println(microsoftSecond.solution(2, "1A 1B 1F 2F 2D"));
    }
}
