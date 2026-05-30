class Solution {
    class SegmentTree {
        int n;
        int[] tree;

        public SegmentTree(int size) {
            n = 1;

            while (n <= size) {
                n *= 2;
            }

            tree = new int[2 * n];
        }

        public void update(int i, int val) {
            for (tree[i += n] = val; i > 1; i >>= 1) {
                tree[i >> 1] = Math.max(tree[i], tree[i ^ 1]);
            }
        }

        public int query(int r) {
            int answer = 0;

            for (int l = n, rIndex = r + n + 1; l < rIndex; l >>= 1, rIndex >>= 1) {
                if ((l & 1) != 0) {
                    answer = Math.max(answer, tree[l++]);
                }

                if ((rIndex & 1) != 0) {
                    answer = Math.max(answer, tree[--rIndex]);
                }
            }

            return answer;
        }
    }

    public List<Boolean> getResults(int[][] queries) {
        int maxX = 0;

        for (int[] q : queries) {
            maxX = Math.max(maxX, q[1]);
        }

        SegmentTree st = new SegmentTree(maxX + 1);
        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        List<Boolean> answer = new ArrayList<>();

        for (int[] q : queries) {
            int x = q[1];

            if (q[0] == 1) {
                Integer next = obstacles.ceiling(x);
                Integer prev = obstacles.floor(x);

                st.update(x, x - prev);

                if (next != null) {
                    st.update(next, next - x);
                }

                obstacles.add(x);
            } else {
                int size = q[2];
                Integer prev = obstacles.floor(x);
                int max = Math.max(x - prev, st.query(prev));
                answer.add(size <= max);
            }
        }

        return answer;
    }
}
