class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();
        int MOD = (int) 1e9 + 7;

        int[] countEndWith = new int[26];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            int cur = (int) ((1L + sum - countEndWith[index] + MOD) % MOD);

            sum = (sum + cur) % MOD;
            countEndWith[index] = (countEndWith[index] + cur) % MOD;
        }

        return sum;
    }
}
