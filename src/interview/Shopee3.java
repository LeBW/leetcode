package interview;

/**
 * 一个机器人要从起始点A和终点B。机器人从起点开始，每次能从上，下，左，右移动一步通过一个房间。并且每个房间只能路过一次。
 *
 * 设定机器人的健康数为H，如果经过的房间是正整数a，那么机器人经过这个房间就能获得对应的健康点数，健康数变成H+a，如果经过的房间为负数，那么机器人就会失去对应的健康点数a， 机器人的健康数变成H-a，问如果要保证机器人生命数一直是正数，H初始值至少为多少？
 *
 * 房间点数由一个二维数组M*N 表示，起点和终点由一个一维数组组成。
 *
 * 以下代码只通过 50%。。
 * @author LBW
 */
public class Shopee3 {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     *
     * @param rooms int整型二维数组 房间
     * @param startPoint int整型一维数组 起始点
     * @param endPoint int整型一维数组 终点
     * @return int整型
     */
    public int minimumInitHealth(int[][] rooms, int[] startPoint, int[] endPoint) {
        // write code here
        int m = rooms.length, n = rooms[0].length;
        boolean[][] isfinished = new boolean[m][n];
//        int[][] res = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                res[i][j] = Integer.MIN_VALUE;
//            }
//        }
        // PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);
        // queue.add(new Node(startPoint[0], startPoint[1], rooms[startPoint[0]][startPoint[1]]));
        int curx = startPoint[0], cury = startPoint[1], curVal = rooms[startPoint[0]][startPoint[1]];
        int min = 0;
        while (curx != endPoint[0] || cury != endPoint[1]) {
            // Node cur = queue.poll();
            isfinished[curx][cury] = true;
            //res[curx][cury] = curVal;
            if (curVal < min) {
                min = curVal;
            }
            // find next curx and cury
            int[] direction = findNextdirection(rooms, curx, cury, isfinished);
            curx += direction[0];
            cury += direction[1];
            curVal += rooms[curx][cury];
        }
        if (curVal < min) {
            min = curVal;
        }
        return 1 - min;
    }

    private int[] findNextdirection(int[][] rooms, int curx, int cury, boolean[][] isfinished) {
        int[] res = directions[0];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < directions.length; i++) {
            int r = curx + directions[i][0];
            int c = cury + directions[i][1];
            if (r >= 0 && r < rooms.length && c >= 0 && c < rooms[0].length && !isfinished[r][c]) {
                if (rooms[r][c] > max) {
                    max = rooms[r][c];
                    res = directions[i];
                }
            }
        }
        return res;
    }


    class Node {
        int r;
        int c;
        int value;

        public Node(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }
    }

    private final static int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    public static void main(String[] args) {
        Shopee3 shopee3 = new Shopee3();
        System.out.println(shopee3.minimumInitHealth(new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}, new int[]{0, 0}, new int[]{2, 2}));
    }
}
