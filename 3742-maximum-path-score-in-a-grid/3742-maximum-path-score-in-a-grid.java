class Solution {
    int limit;

    private int compute(int i, int j, int cost, int[][] grid, int k, int[][][] dp) {
        if (cost > k) {
            return limit;
        }

        if (dp[i][j][cost] != -1) {
            return dp[i][j][cost];
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            if (grid[i][j] != 0 && cost + 1 > k) {
                return limit;
            }

            return grid[i][j];
        }

        if (i == grid.length || j == grid[0].length) {
            return limit;
        }

        int answer = limit;
        int toAdd = grid[i][j] != 0 ? 1 : 0;
        answer = Math.max(answer, compute(i + 1, j, cost + toAdd, grid, k, dp));
        answer = Math.max(answer, compute(i, j + 1, cost + toAdd, grid, k, dp));

        return dp[i][j][cost] = (answer == limit ? answer : answer + grid[i][j]);
    }

    public int maxPathScore(int[][] grid, int k) {
        limit = -2;
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m + 1][n + 1][Math.min(k + 1, m + n + 1)];

        for (int[][] i : dp) {
            for (int[] j : i) {
                Arrays.fill(j, -1);
            }
        }

        int answer = compute(0, 0, 0, grid, k, dp);

        return answer == limit ? -1 : answer;
    }
}
