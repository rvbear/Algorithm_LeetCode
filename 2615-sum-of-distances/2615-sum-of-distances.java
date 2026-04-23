class Solution {
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        long[] answer = new long[n];

        for (List<Integer> v : map.values()) {
            if (v.size() > 1) {
                int c = v.size();
                int i = v.get(0);
                long sum = 0;

                for (int x : v) {
                    sum += x;
                }

                answer[i] = sum - (long) c * i;
                int x = 0, y = c - 2;

                for (int k = 1; k < c; k++) {
                    int nowIndex = v.get(k);
                    answer[nowIndex] = answer[i] + (long) (x - y) * (nowIndex - i);
                    x++;
                    y--;
                    i = nowIndex;
                }
            }
        }

        return answer;
    }
}
