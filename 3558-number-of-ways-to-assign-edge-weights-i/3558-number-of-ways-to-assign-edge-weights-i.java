class Solution {
    private static final int MOD = 1_000_000_007;

    private int dfs(int node, int prev, List<Integer>[] graph) {
        int dist = 0;

        for (int g : graph[node]) {
            if (g != prev) {
                dist = Math.max(dist, dfs(g, node, graph) + 1);
            }
        }

        return dist;
    }

    private long pow(long base, int exp) {
        long answer = 1;

        while (exp > 0) {
            if (exp % 2 > 0) {
                answer = answer * base % MOD;
            }

            base = base * base % MOD;
            exp /= 2;
        }

        return answer;
    }

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] graph = new ArrayList[n + 1];
        Arrays.setAll(graph, i -> new ArrayList<>());

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        return (int) pow(2, dfs(1, 0, graph) - 1);
    }
}
