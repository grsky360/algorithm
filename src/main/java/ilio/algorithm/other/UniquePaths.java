package ilio.algorithm.other;

/**
 * @Author hyia
 * @Date 2020/10/10 19:42
 * @url https://leetcode-cn.com/problems/unique-paths/
 * @url https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        final int rows = m;
        final int cols = n;
        final int[] dp = new int[cols];
        for (int col = 0; col < cols; col++) {
            dp[col] = 1;
        }
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                dp[col] += dp[col - 1];
            }
        }
        return dp[cols - 1];
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        final int rows = obstacleGrid.length;
        final int cols = obstacleGrid[0].length;
        final int[] dp = new int[cols];
        dp[0] = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (obstacleGrid[row][col] == 1) {
                    dp[col] = 0;
                } else if (col > 0 && obstacleGrid[row][col - 1] == 0) {
                    dp[col] += dp[col - 1];
                }
            }
        }
        return dp[cols - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2)); // 3
        System.out.println(uniquePaths(7, 3)); // 28

        System.out.println(uniquePathsWithObstacles(new int[][]{
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        })); // 2
        System.out.println(uniquePathsWithObstacles(new int[][]{
            {0, 0},
            {1, 1},
            {0, 0}
        })); // 0
    }
}
