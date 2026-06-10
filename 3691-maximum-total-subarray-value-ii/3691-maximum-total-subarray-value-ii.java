class Solution {
    class SparseTable {
        private int[][] min, max;

        public SparseTable(int[] num) {
            int n = num.length;
            int bitWidth = 32 - Integer.numberOfLeadingZeros(n);
            min = new int[bitWidth][n];
            max = new int[bitWidth][n];

            for (int i = 0; i < n; i++) {
                min[0][i] = max[0][i] = num[i];
            }

            for (int i = 1; i < bitWidth; i++) {
                for (int j = 0; j + (1 << i) <= n; j++) {
                    min[i][j] = Math.min(min[i - 1][j], min[i - 1][j + (1 << (i - 1))]);
                    max[i][j] = Math.max(max[i - 1][j], max[i - 1][j + (1 << (i - 1))]);
                }
            }
        }

        public int query(int left, int right) {
            int k = 31 - Integer.numberOfLeadingZeros(right - left);

            return Math.max(max[k][left], max[k][right - (1 << k)]) - Math.min(min[k][left], min[k][right - (1 << k)]);
        }
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        SparseTable lut = new SparseTable(nums);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            pq.add(new int[] { lut.query(i, n), i , n });
        }

        long answer = 0;

        while (pq.peek()[0] > 0) {
            int[] top = pq.poll();
            answer += top[0];
            top[2]--;
            top[0] = lut.query(top[1], top[2]);
            pq.add(top);

            if (--k <= 0) {
                break;
            }
        }

        return answer;
    }
}
