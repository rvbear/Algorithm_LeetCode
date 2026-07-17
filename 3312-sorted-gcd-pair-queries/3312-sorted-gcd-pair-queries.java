class Solution {
    private int upperBound(long[] s, long q) {
        int lo = 0, hi = s.length;

        while (lo < hi) {
            int mid = (lo + hi) >>> 1;

            if (s[mid] > q) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public int[] gcdValues(int[] nums, long[] queries) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] freq = new int [max + 1];

        for (int v : nums) {
            ++freq[v];
        }

        long[] g = new long[max + 1];

        for (int d = max; d > 0; d--) {
            long m = 0;

            for (int k = d; k <= max; k += d) {
                m += freq[k];
                g[d] -= g[k];
            }

            g[d] += m * (m - 1) / 2;
        }

        long[] s = g.clone();
        Arrays.parallelPrefix(s, Long::sum);

        return Arrays.stream(queries).mapToInt(q -> upperBound(s, q)).toArray();
    }
}
