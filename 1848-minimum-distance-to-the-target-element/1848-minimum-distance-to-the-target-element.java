class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int min = nums.length + 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                min = Math.min(Math.abs(i - start), min);
            }
        }

        return min;
    }
}
