/**
 * 1232. Check If it is a Straight Line
 * @author LBW
 */
public class CheckIfItStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        if (n <= 2)
            return true;
        int deltaY = coordinates[0][1] - coordinates[1][1];
        int deltaX = coordinates[0][0] - coordinates[1][0];
        if (deltaY == 0) {
            for (int i = 2; i < n; i++) {
                if (coordinates[i][1] != coordinates[0][1])
                    return false;
            }
            return true;
        }
        for (int i = 1; i < n; i++) {
            if ((coordinates[i][1] - coordinates[0][1]) * deltaX != (coordinates[i][0] - coordinates[0][0]) * deltaY) {
                return false;
            }
        }
        return true;
    }
}
