class Solution {
    private static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        int[][] dist = new int[n][n];
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.add(new int[] {i, j});
                    dist[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] pop = q.poll();
            int r = pop[0], c = pop[1];

            for (int d[] : dir) {
                int nr = d[0] + r;
                int nc = d[1] + c;

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[r][c] + 1;
                    q.add(new int[]{nr, nc});
                }
            }

        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        boolean[][] vis = new boolean[n][n];

        pq.add(new int[] {dist[0][0], 0, 0});
        vis[0][0] = true;

        while (!pq.isEmpty()) {
            int[] pop = pq.poll();
            int safenessFactor = pop[0];
            int r = pop[1], c = pop[2];

            if (r == n - 1 && c == n - 1) {
                return safenessFactor;
            }

            for (int d[] : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !vis[nr][nc]) {
                    int newSafeness = Math.min(safenessFactor, dist[nr][nc]);

                    pq.add(new int[] {newSafeness, nr, nc});
                    vis[nr][nc] = true;
                }
            }
        }

        return 0;
    }
}
