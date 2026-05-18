class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        
        if (n == 1) {
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});

        boolean[] visited = new boolean[n];
        visited[0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int dist = cur[1];

            if (node == n - 1) {
                return dist;
            }

            if (node - 1 >= 0 && !visited[node - 1]) {
                visited[node - 1] = true;
                q.offer(new int[] {node - 1, dist + 1});
            }

            if (node + 1 < n && !visited[node + 1]) {
                visited[node + 1] = true;
                q.offer(new int[] {node + 1, dist + 1});
            }

            for (int next : map.get(arr[node])) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[] {next, dist + 1});
                }
            }

            map.get(arr[node]).clear();
        }

        return -1;
    }
}
