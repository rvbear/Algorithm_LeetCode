class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        long[][] arr = new long[n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j + 1] = arr[i][j] + grid[j][i];
            }
        }

        long[] pdp = new long[n + 1];
        long[] pep = new long[n + 1];

        for (int i = 1; i < n; i++) {
            long[] dp = new long[n + 1];
            long[] ep = new long[n + 1];

            for (int pb = 0; pb <= n; pb++) {
                for (int cb = 0; cb <= n; cb++) {
                    long pv = 0;

                    if (cb > pb) {
                        pv = arr[i - 1][cb] - arr[i - 1][pb];
                    }

                    long cv = 0;

                    if (cb < pb) {
                        cv = arr[i][pb] - arr[i][cb];
                    }

                    dp[cb] = Math.max(dp[cb], Math.max(pv + pdp[pb], pep[pb]));
                    ep[cb] = Math.max(ep[cb], Math.max(cv + pep[pb], cv + pv + pdp[pb]));
                }
            }

            pdp = dp;
            pep = ep;
        }

        long answer = 0;

        for (long v : pep) {
            answer = Math.max(answer, v);
        }

        return answer;
    }
}
