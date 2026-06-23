class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int[] dp = new int[m];
        Arrays.fill(dp, 1);

        for (int i = 2; i <= n; i++) {
            if ((i & 1) == 0) {
                long pref = 0;

                for (int j = 0; j < m; j++) {
                    int old = dp[j];
                    dp[j] = (int) pref;
                    pref = (pref + old) % MOD;
                }
            } else {
                long suff = 0;

                for (int j = m - 1; j >= 0; j--) {
                    int old = dp[j];
                    dp[j] = (int) suff;
                    suff = (suff + old) % MOD;
                }
            }
        }

        long answer = 0;

        for (int x : dp) {
            answer = (answer + x) % MOD;
        }

        return (int) ((answer * 2) % MOD);
    }
}
