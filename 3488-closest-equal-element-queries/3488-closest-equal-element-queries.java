class Solution {
    private int circularDistance(int from, int to, int n) {
        if (from <= to) {
            return to - from;
        }

        return n - from + to;
    }

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int[] distances = new int[nums.length];
        Map<Integer, int[]> lastSeen = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            distances[i] = Integer.MAX_VALUE;

            if (lastSeen.containsKey(nums[i])) {
                int lastSeenIndexLeft = lastSeen.get(nums[i])[0];
                int lastSeenIndexRight = lastSeen.get(nums[i])[1];

                distances[lastSeenIndexRight] = Math.min(distances[lastSeenIndexRight], circularDistance(lastSeenIndexRight, i, n));
                distances[lastSeenIndexLeft] = Math.min(distances[lastSeenIndexLeft], circularDistance(i, lastSeenIndexLeft, n));
                distances[i] = Math.min(circularDistance(lastSeenIndexRight, i, n), circularDistance(i, lastSeenIndexLeft, n));

                lastSeen.put(nums[i], new int[] { lastSeen.get(nums[i])[0], i });
            } else {
                lastSeen.put(nums[i], new int[] { i, i });
            }
        }
        
        List<Integer> answer = new ArrayList<>();

        for(int q : queries) {
            answer.add(distances[q] == Integer.MAX_VALUE ? -1 : distances[q]);
        }

        return answer;
    }
}
