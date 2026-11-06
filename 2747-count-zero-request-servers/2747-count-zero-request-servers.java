class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int q = queries.length;
        Integer[] index = new Integer[q];

        for (int i = 0; i < q; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (a, b) -> Integer.compare(queries[a], queries[b]));

        int[] count = new int[n + 1];
        int[] answer = new int[q];
        int distinct = 0, l = 0, r = 0;

        for (int idx : index) {
            int t = queries[idx];

            while (r < logs.length && logs[r][1] <= t) {
                if (count[logs[r][0]]++ == 0) {
                    distinct++;
                }

                r++;
            }

            while (l < r && logs[l][1] < t - x) {
                if (--count[logs[l][0]] == 0) {
                    distinct--;
                }

                l++;
            }

            answer[idx] = n - distinct;
        }

        return answer;
    }
}
