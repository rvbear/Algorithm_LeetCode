class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        if (s.charAt(n - 1) == '1') {
            return false;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        int reach = 0, maxR = maxJump;

        for (int i = minJump; i < n; i++) {
            if (i > maxR) {
                return false;
            }

            reach += dp[i - minJump];

            if (i > maxJump) {
                reach -= dp[i - maxJump - 1];
            }

            if (reach > 0 && s.charAt(i) == '0') {
                dp[i] = 1;
                maxR = i + maxJump;
            }
        }

        return reach > 0;
    }
}
