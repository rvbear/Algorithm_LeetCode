class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] - nums[i] >= -target && nums[j] - nums[i] <= target) {
                    if (i != 0 && dp[i] == 0) {
                        continue;
                    }

                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        return dp[n - 1] == 0 ? -1 : dp[n - 1];
    }
}
