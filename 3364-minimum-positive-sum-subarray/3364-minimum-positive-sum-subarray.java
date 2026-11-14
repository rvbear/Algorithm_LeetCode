class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size(), min = Integer.MAX_VALUE;

        for (int add = l; add <= r; add++) {
            for (int i = 0; i < n - add + 1; i++) {
                int temp = 0;

                for (int j = i; j < i + add; j++) {
                    temp += nums.get(j);
                }

                min = (temp > 0) ? Math.min(min, temp) : min;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
