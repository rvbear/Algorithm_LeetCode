class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int mid = nums[nums.length / 2];
        long moves = 0;

        for (int num : nums) {
            moves += Math.abs(num - mid);
        }

        return (int) moves;
    }
}
