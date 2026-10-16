class Solution {
    private static final long MOD = 1_000_000_007L;

    private long[] count, sq, lazy;

    private void apply(int node, int l, int r, long v) {
        long len = r - l + 1L;

        sq[node] = (sq[node] + 2L * v * count[node] + len * v * v) % MOD;
        count[node] = (count[node] + len * v) % MOD;
        lazy[node] += v;
    }

    private void update(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            apply(node, l, r, 1);
            return;
        }

        int mid = (l + r) / 2;
        int lc = node * 2;
        int rc = lc + 1;

        if (lazy[node] != 0) {
            apply(lc, l, mid, lazy[node]);
            apply(rc, mid + 1, r, lazy[node]);
            lazy[node] = 0;
        }

        if (ql <= mid) {
            update(lc, l, mid, ql, qr);
        }

        if (qr > mid) {
            update(rc, mid + 1, r, ql, qr);
        }

        count[node] = (count[lc] + count[rc]) % MOD;
        sq[node] = (sq[lc] + sq[rc]) % MOD;
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;

        count = new long[4 * n];
        sq = new long[4 * n];
        lazy = new long[4 * n];

        Map<Integer, Integer> last = new HashMap<>();
        long answer = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int l = last.getOrDefault(x, -1) + 1;
            last.put(x, i);

            update(1, 0, n - 1, l, i);
            answer = (answer + sq[1]) % MOD;
        }

        return (int) answer;
    }
}
