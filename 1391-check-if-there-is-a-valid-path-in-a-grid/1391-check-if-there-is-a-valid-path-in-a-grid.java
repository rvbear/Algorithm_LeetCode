class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<Integer>[] dirs = new HashSet[7];

        dirs[1] = new HashSet<>(Arrays.asList(0, 1));
        dirs[2] = new HashSet<>(Arrays.asList(2, 3));
        dirs[3] = new HashSet<>(Arrays.asList(0, 3));
        dirs[4] = new HashSet<>(Arrays.asList(1, 3));
        dirs[5] = new HashSet<>(Arrays.asList(0, 2));
        dirs[6] = new HashSet<>(Arrays.asList(1, 2));

        int[][] moves = {{0, -1, 0, 1}, {0, 1, 1, 0}, {-1, 0, 2, 3}, {1, 0, 3, 2}};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[] {0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if (r == m - 1 && c == n - 1) {
                return true;
            }

            for (int[] move : moves) {
                int nr = r + move[0], nc = c + move[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    if (dirs[grid[r][c]].contains(move[2]) && dirs[grid[nr][nc]].contains(move[3])) {
                        visited[nr][nc] = true;
                        q.offer(new int[] {nr, nc});
                    }
                }
            }
        }

        return false;
    }
}
