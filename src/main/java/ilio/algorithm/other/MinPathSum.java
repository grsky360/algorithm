package ilio.algorithm.other;

public class MinPathSum {

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        for (int row = 1; row < grid.length; row++) {
            grid[row][0] = grid[row][0] + grid[row - 1][0];
        }
        for (int col = 1; col < grid[0].length; col++) {
            grid[0][col] = grid[0][col] + grid[0][col - 1];
        }
        for (int row = 1; row < grid.length; row++) {

            for (int col = 1; col < grid[0].length; col++) {
                grid[row][col] += Math.min(grid[row - 1][col], grid[row][col - 1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        }));
    }
}
