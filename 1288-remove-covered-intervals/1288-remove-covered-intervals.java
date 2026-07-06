class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        int n = intervals.length, count = 0;
        int low = intervals[0][0], high = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] == low || intervals[i][1] <= high) {
                count++;
            } else {
                low = intervals[i][0];
                high = intervals[i][1];
            }
        }

        return n - count;
    }
}
