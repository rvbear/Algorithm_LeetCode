class Solution {
    private int answer;
    private boolean[][][] memo;

    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int startVal = grid[0][0];
        answer = Integer.MAX_VALUE;
        memo = new boolean[m][n][1024];

        dfs(grid, 0, 0, 0, m, n);

        return answer;
    }

    private void dfs(int[][] grid, int i, int j, int xor, int m, int n) {
        xor ^= grid[i][j];

        if (answer == 0) {
            return;
        }

        if (memo[i][j][xor]) {
            return;
        }

        memo[i][j][xor] = true;
        
        if (i == m - 1 && j == n - 1) {
            answer = Math.min(answer, xor);
            return;
        }

        if (i + 1 < m) {
            dfs(grid, i + 1, j, xor, m, n);
        }

        if (j + 1 < n) {
            dfs(grid, i, j + 1, xor, m, n);
        }
    }
}
