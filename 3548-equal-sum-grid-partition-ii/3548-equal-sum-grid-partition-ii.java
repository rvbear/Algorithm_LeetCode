class Solution {
    private boolean canRemove(int r1, int r2, int c1, int c2, int i, int j) {
        int rows = r2 - r1 + 1;
        int cols = c2 - c1 + 1;

        if (rows * cols == 1) {
            return false;
        }

        if (rows == 1) {
            return (j == c1 || j == c2);
        }

        if (cols == 1) {
            return (i == r1 || i == r2);
        }

        return true;
    }

    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[] prefRow = new long[m];
        long[] prefCol = new long[n];

        Map<Long, List<int[]>> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            long val = 0;

            for (int j = 0; j < n; j++) {
                val += grid[i][j];
                long cellVal = (long) grid[i][j];
                map.putIfAbsent(cellVal, new ArrayList<>());
                map.get(cellVal).add(new int[] {i, j});
            }

            prefRow[i] = val + (i > 0 ? prefRow[i - 1] : 0);
        }

        for (int j = 0; j < n; j++) {
            long val = 0;

            for (int i = 0; i < m; i++) {
                val += grid[i][j];
            }

            prefCol[j] = val + (j > 0 ? prefCol[j - 1] : 0);
        }

        long total = prefRow[m - 1];

        for (int i = 0; i < m - 1; i++) {
            long top = prefRow[i];
            long bottom = total - top;

            if (top == bottom) {
                return true;
            }

            long diff = Math.abs(top - bottom);

            if (!map.containsKey(diff)) {
                continue;
            }

            if (top > bottom) {
                for (int[] p : map.get(diff)) {
                    int x = p[0], y = p[1];

                    if (x <= 1 && canRemove(0, i, 0, n - 1, x, y)) {
                        return true;
                    }
                }
            } else {
                for (int[] p : map.get(diff)) {
                    int x = p[0], y = p[1];

                    if (x > i && canRemove(i + 1, m - 1, 0, n - 1, x, y)) {
                        return true;
                    }
                }
            }
        }

        for (int j = 0; j < n - 1; j++) {
            long left = prefCol[j];
            long right = total - left;

            if (left == right) {
                return true;
            }

            long diff = Math.abs(left - right);

            if (!map.containsKey(diff)) {
                continue;
            }

            if (left > right) {
                for (int[] p : map.get(diff)) {
                    int x = p[0], y = p[1];

                    if (y <= j && canRemove(0, m - 1, 0, j, x, y)) {
                        return true;
                    }
                }
            } else {
                for (int[] p : map.get(diff)) {
                    int x = p[0], y = p[1];

                    if (y > j && canRemove(0, m - 1, j + 1, n - 1, x, y)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}