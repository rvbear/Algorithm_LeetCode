class Solution {
    private int m, n;
    private Boolean[][][] dp;

    private boolean solve(int i, int j, int openCount, char[][] grid) {
        openCount += (grid[i][j] == '(') ? 1 : -1;

        if (openCount < 0) {
            return false;
        }

        if (openCount > m + n - 1) {
            return false;
        }

        if (dp[i][j][openCount] != null) {
            return dp[i][j][openCount];
        }

        if (i == m - 1 && j == n - 1) {
            return dp[i][j][openCount] = (openCount == 0);
        }

        if (i + 1 < m) {
            if (solve(i + 1, j, openCount, grid)) {
                return dp[i][j][openCount] = true;
            }
        }

        if (j + 1 < n) {
            if (solve(i, j + 1, openCount, grid)) {
                return dp[i][j][openCount] = true;
            }
        }

        return dp[i][j][openCount] = false;
    }

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        if ((m + n - 1) % 2 == 1) {
            return false;
        }

        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        dp = new Boolean[m][n][m + n];

        return solve(0, 0, 0, grid);
    }
}
