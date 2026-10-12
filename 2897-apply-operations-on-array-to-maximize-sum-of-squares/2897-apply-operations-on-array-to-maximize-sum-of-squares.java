class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] b = new int[30];
        long answer = 0, mod = 1_000_000_007;

        for (int x : nums) {
            for (int i = 0; i < 30; i++) {
                if ((x & (1 << i)) != 0) {
                    b[i]++;
                }
            }
        }

        while (k-- > 0) {
            long x = 0;

            for (int i = 0; i < 30; i++) {
                if (b[i] > 0) {
                    x |= 1L << i;
                    b[i]--;
                }
            }

            answer = (answer + x * x) % mod;
        }

        return (int) answer;
    }
}
