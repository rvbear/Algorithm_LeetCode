class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int min = nums[0], max = nums[0];

        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        return (long) (max - min) * k;
    }
}
