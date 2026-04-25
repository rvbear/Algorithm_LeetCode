class Solution {
    private boolean check(int n, long[] result, long leftSide, int k) {
        int m = result.length;
        int[] index = new int[k];
        long perimeter = leftSide * 4;
        
        index[0] = 0;
        long cur = result[0];

        for (int i = 1; i < k; i++) {
            int pos = Arrays.binarySearch(result, cur + n);

            if (pos < 0) {
                pos = -(pos + 1);
            }

            if (pos == m) {
                return false;
            }

            index[i] = pos;
            cur = result[pos];
        }

        if (result[index[k - 1]] - result[0] <= perimeter - n) {
            return true;
        }

        for (index[0] = 1; index[0] < index[1]; index[0]++) {
            for (int j = 1; j < k; j++) {
                while (index[j] < m && result[index[j]] < result[index[j - 1]] + n) {
                    index[j]++;
                }

                if (index[j] == m) {
                    return false;
                }
            }

            if (result[index[k - 1]] - result[index[0]] <= perimeter - n) {
                return true;
            }
        }

        return false;
    }

    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] result = new long[n];
        long leftSide = (long) side;

        for (int i = 0; i < n; i++) {
            long x = points[i][0];
            long y = points[i][1];

            if (x == 0) {
                result[i] = y;
            } else if (y == leftSide) {
                result[i] = leftSide + x;
            } else if (x == leftSide) {
                result[i] = leftSide * 3 - y;
            } else {
                result[i] = leftSide * 4 - x;
            }
        }

        Arrays.sort(result);

        int left = 1;
        int right = (int) ((leftSide * 4) / k) + 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (check(mid, result, leftSide, k)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
