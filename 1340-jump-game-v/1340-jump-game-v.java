class Solution {
    private int dfs(int i, int[] left, int[] right, int[] memo) {
        if (i < 0) {
            return 0;
        }

        if (memo[i] == 0) {
            memo[i] = Math.max(dfs(left[i], left, right, memo), dfs(right[i], left, right, memo)) + 1;
        }

        return memo[i];
    }

    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] left = new int[n];
        int[] st = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            int x = arr[i];

            while (top >= 0 && arr[st[top]] <= x) {
                top--;
            }

            left[i] = top < 0 || i - st[top] > d ? -1 : st[top];
            st[++top] = i;
        }

        int[] right = new int[n];
        top = -1;

        for (int i = n - 1; i >= 0; i--) {
            int x = arr[i];

            while (top >= 0 && arr[st[top]] <= x) {
                top--;
            }

            right[i] = top < 0 || st[top] - i > d ? -1 : st[top];
            st[++top] = i;
        }

        int[] memo = new int[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dfs(i, left, right, memo));
        }

        return answer;
    }
}
