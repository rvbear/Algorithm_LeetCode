class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> result = new ArrayList<>();

        for (int[] row : grid) {
            for (int v : row) {
                result.add(v);
            }
        }

        int mod = result.get(0) % x;

        for (int v : result) {
            if (v % x != mod) {
                return -1;
            }
        }

        Collections.sort(result);
        int m = result.get(result.size() / 2);
        int count = 0;

        for (int v : result) {
            count += Math.abs(v - m) / x;
        }

        return count;
    }
}
