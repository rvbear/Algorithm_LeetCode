class Solution {
    private String s;
    private Map<String, long[]> map = new HashMap<>();

    private long[] dfs(int i, int a, int b, int t, int st, int len) {
        if (i == s.length()) {
            return new long[] {1, 0};
        }

        String key = i + "," + a + "," + b + "," + t + "," + st + "," + len;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        long count = 0, wave = 0;
        int limit = t == 1 ? (s.charAt(i) - '0') : 9;

        for (int d = 0; d <= limit; d++) {
            long[] result = dfs(i + 1, b, d, 
                t == 1 && d == (s.charAt(i) - '0') ? 1 : 0,
                (st == 1 || d > 0) ? 1 : 0,
                (st == 1 || d > 0) ? len + 1 : 0);
            long c = result[0], w = result[1];

            if (len > 1 && ((a < b && b > d) || (a > b && b < d))) {
                w += c;
            }

            count += c;
            wave += w;
        }

        long[] answer = {count, wave};
        map.put(key, answer);

        return answer;
    }

    private long solve(long n) {
        s = Long.toString(n);
        map.clear();
        
        return dfs(0, 0, 0, 1, 0, 0)[1];
    }

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }
}
