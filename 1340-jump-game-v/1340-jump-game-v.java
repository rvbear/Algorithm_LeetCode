class Solution {
    int n;
    int[] dp;

    private int dfs(int i, int[] arr, int d) {
        if (dp[i] != 0) {
            return dp[i];
        }

        int best = 1;

        for (int next = i + 1; next <= Math.min(n - 1, i + d); next++) {
            if (arr[next] >= arr[i]) {
                break;
            }

            best = Math.max(best, 1 + dfs(next, arr, d));
        }

        for (int next = i - 1; next >= Math.max(0, i - d); next--) {
            if (arr[next] >= arr[i]) {
                break;
            }

            best = Math.max(best, 1 + dfs(next, arr, d));
        }

        return dp[i] = best;
    }

    public int maxJumps(int[] arr, int d) {
        n = arr.length;
        dp = new int[n];

        int answer = 1;

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dfs(i, arr, d));
        }

        return answer;
    }
}
