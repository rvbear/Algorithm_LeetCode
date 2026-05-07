class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length, min = Integer.MAX_VALUE;
        int[] ans = new int[n];
        ans[0] = nums[0];

        for (int i = 1; i < n; i++) {
            ans[i] = Math.max(ans[i - 1], nums[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            min = Math.min(min, nums[i + 1]);

            if (min < ans[i]) {
                ans[i] = ans[i + 1];
            }
        }

        return ans;
    }
}
