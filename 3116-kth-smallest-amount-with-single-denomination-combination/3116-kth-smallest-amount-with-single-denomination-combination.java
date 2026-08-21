class Solution {
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
    
    private boolean check(int[] coins, int k, long max) {
        long count = 0;
        int n = coins.length;

        for (int i = 1; i < 1 << n; i++) {
            long value = 1;

            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1) {
                    value = lcm(value, coins[j]);

                    if (value > max) {
                        break;
                    }
                }
            }

            int m = Integer.bitCount(i);

            if (m % 2 == 1) {
                count += max / value;
            } else {
                count -= max / value;
            }
        }

        return count >= k;
    }

    public long findKthSmallest(int[] coins, int k) {
        long left = 1, right = (long) 1e11;

        while (left < right) {
            long mid = (left + right) >> 1;

            if (check(coins, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
