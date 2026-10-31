class Solution {
    private static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int[] down = new int[grid[0].length];
        down[0] = 1;

        for (int[] row : grid) {
            int right = 0;

            for (int j = 0; j < row.length; j++) {
                if (row[j] == 1) {
                    int t = right;
                    right = down[j];
                    down[j] = t;
                } else {
                    right = down[j] = (right + down[j]) % MOD;
                }
            }
        }

        return down[down.length - 1];
    }
}
