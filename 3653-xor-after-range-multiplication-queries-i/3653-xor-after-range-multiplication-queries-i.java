class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            for (int i = l; i <= r; i += k) {
                long temp = nums[i];
                nums[i] = (int)((temp * v) % 1_000_000_007);
            }
        }

        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }

        return ans;
    }
}
