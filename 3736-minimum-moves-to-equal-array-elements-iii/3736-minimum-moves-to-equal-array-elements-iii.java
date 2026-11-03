class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);

        int target = nums[nums.length - 1];
        long answer = 0;

        for (int num : nums) {
            answer += target - num;
        }

        return (int) answer;
    }
}
