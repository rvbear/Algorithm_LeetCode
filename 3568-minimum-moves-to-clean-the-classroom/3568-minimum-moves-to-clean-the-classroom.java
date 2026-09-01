class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int[][] litterMap = new int[m][n];
        int startX = -1, startY = -1;
        int litterCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);

                if (c == 'S') {
                    startX = i;
                    startY = j;
                } else if (c == 'L') {
                    litterMap[i][j] = litterCount++;
                }
            }
        }

        if (litterCount == 0) {
            return 0;
        }

        int targetMask = (1 << litterCount) - 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {startX, startY, energy, 0, 0});

        boolean[][][][] visited = new boolean[m][n][energy + 1][1 << litterCount];

        visited[startX][startY][energy][0] = true;

        int[] dirs = {-1, 0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], e = cur[2], mask = cur[3], steps = cur[4];

            for (int i = 0; i < 4; i++) {
                int nr = r + dirs[i];
                int nc = c + dirs[i + 1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && classroom[nr].charAt(nc) != 'X') {
                    int nextE = e - 1;
                    int nextMask = mask;
                    char nextCell = classroom[nr].charAt(nc);

                    if (nextCell == 'L') {
                        nextMask |= (1 << litterMap[nr][nc]);
                    }

                    if (nextMask == targetMask) {
                        return steps + 1;
                    }

                    if (nextCell == 'R') {
                        nextE = energy;
                    }

                    if (nextE == 0 && nextCell != 'R') {
                        continue;
                    }

                    if (!visited[nr][nc][nextE][nextMask]) {
                        visited[nr][nc][nextE][nextMask] = true;
                        q.offer(new int[] {nr, nc, nextE, nextMask, steps + 1});
                    }
                }
            }
        }

        return -1;
    }
}
