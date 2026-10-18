class Solution {
    private static int[][] pascalsTriangle = createPascalsTriangle(1001);
    private static final int MOD = 1_000_000_007;

    public int numOfWays(int[] nums) {
        return dfs(nums, nums.length) - 1;    
    }

    private int dfs(int[] nums, int n) {
        if (n <= 2) {
            return 1;
        }

        final int[] left = new int[n - 1];
        final int[] right = new int[n - 1];
        final int rootVal = nums[0];
        int leftIndex = 0, rightIndex = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < rootVal) {
                left[leftIndex++] = nums[i];
            } else {
                right[rightIndex++] = nums[i];
            }
        }

        return (int)(((((long) dfs(left, leftIndex) * dfs(right, rightIndex)) % MOD) * pascalsTriangle[n - 1][leftIndex]) % MOD);
    }

    static private int[][] createPascalsTriangle(int maxN) {
        int[][] pt = new int[maxN][];

        for (int i = 0; i < maxN; i++) {
            pt[i] = new int[i + 1];
            pt[i][0] = pt[i][i] = 1;

            for (int j = 1; j < i; j++) {
                pt[i][j] = (pt[i - 1][j - 1] + pt[i - 1][j]) % MOD;
            }
        }

        return pt;
    }
}
