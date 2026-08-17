class Solution {
    private int game(int[][] dp, int[] a, int i, int j, int total) {
        if (i >= j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int answer = 0, sum = 0;

        for (int k = i; k < j; k++) {
            sum += a[k];

            int sumAfter = total - sum;

            if (sum > sumAfter) {
                answer = Math.max(answer, sumAfter + game(dp, a, k + 1, j, sumAfter));
            } else if (sum < sumAfter) {
                answer = Math.max(answer, sum + game(dp, a, i, k, sum));
            } else {
                answer = Math.max(answer, sum + Math.max(game(dp, a, k + 1, j, sumAfter), game(dp, a, i, k, sum)));
            }
        }

        return dp[i][j] = answer;
    }

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[][] dp = new int[n][n];
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += stoneValue[i];
            Arrays.fill(dp[i], -1);
        }

        return game(dp, stoneValue, 0, n - 1, totalSum);
    }
}
