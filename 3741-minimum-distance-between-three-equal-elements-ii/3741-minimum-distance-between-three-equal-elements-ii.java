class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return -1;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int temp = nums[i];

            if (!map.containsKey(temp)) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(temp, list);
            } else {
                map.get(temp).add(i);
            }
        }

        int min = Integer.MAX_VALUE;

        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);

            if (list.size() < 3) {
                continue;
            }

            for (int i = 0; i <= list.size() - 3; i++) {
                min = Math.min(min, 2 * (list.get(i + 2) - list.get(i)));
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}