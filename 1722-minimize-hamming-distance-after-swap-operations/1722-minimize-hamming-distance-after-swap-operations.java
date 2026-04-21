class Solution {
    int[] parent, rank;

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return;
        }

        if (rank[a] < rank[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        parent[b] = a;
        
        if (rank[a] == rank[b]) {
            rank[a]++;
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] e : allowedSwaps) {
            union(e[0], e[1]);
        }

        Map<Integer, List<Integer>> groups = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = find(i);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        int answer = 0;

        for (List<Integer> indexs : groups.values()) {
            Map<Integer, Integer> freq = new HashMap<>();

            for (int i : indexs) {
                freq.put(source[i], freq.getOrDefault(source[i], 0) + 1);
            }

            for (int i : indexs) {
                if (freq.getOrDefault(target[i], 0) > 0) {
                    freq.put(target[i], freq.get(target[i]) - 1);
                } else {
                    answer++;
                }
            }
        }

        return answer;
    }
}
