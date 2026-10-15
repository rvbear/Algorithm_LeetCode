class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        long[] cnt = new long[n + 1], tot = new long[n + 1];
        Map<Integer, Integer> last = new HashMap<>();
        long answer = 0;

        for (int r = 0; r < n; r++) {
            int x = nums.get(r), p = last.getOrDefault(x, -1);
            long c = 0, s = 0;

            for (int i = n - p - 1; i > 0; i -= i & -i) {
                c += cnt[i];
                s += tot[i];
            }

            answer += (long) (n - r) * ((long) (r - p) * (r - p) - 2 * (s - p * c));

            for (int i = n - p; i <= n; i += i & -i) {
                cnt[i]++;
                tot[i] += p;
            }

            last.put(x, r);
        }

        return (int) answer;
    }
}
