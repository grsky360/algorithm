package ilio.algorithm;

public class MaxArea {

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int cnt = search(grid, rows, cols, row, col);
                res = Math.max(res, cnt);
            }
        }
        return res;
    }

    private static int search(int[][] grid, int rows, int cols, int row, int col) {
        if (row >= rows || row < 0 || col >= cols || col < 0) {
            return 0;
        }
        if (grid[row][col] == 0) {
            return 0;
        }
        int cnt = 1;
        grid[row][col] = 0;
        cnt += search(grid, rows, cols, row - 1, col);
        cnt += search(grid, rows, cols, row + 1, col);
        cnt += search(grid, rows, cols, row, col - 1);
        cnt += search(grid, rows, cols, row, col + 1);

        return cnt;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

//        System.out.println(maxAreaOfIsland(grid));
        System.out.println(maxAreaOfIsland(new int[][] {{1, 0, 1}}));
        System.out.println();
    }
}
