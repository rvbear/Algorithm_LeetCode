class Solution {
    private int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midVal = list.get(mid);

            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (int q : queries) {
            List<Integer> temp = map.get(nums[q]);
            int len = temp.size();

            if (len == 1) {
                answer.add(-1);
            } else {
                int nowIndex = binarySearch(temp, q);

                int prevIndex = temp.get((nowIndex - 1 + len) % len);
                int nextIndex = temp.get((nowIndex + 1) % len);

                int prevDist = Math.min(Math.abs(q - prevIndex), n - Math.abs(q - prevIndex));
                int nextDist = Math.min(Math.abs(q - nextIndex), n - Math.abs(q - nextIndex));

                answer.add(Math.min(prevDist, nextDist));
            }
        }

        return answer;
    }
}
