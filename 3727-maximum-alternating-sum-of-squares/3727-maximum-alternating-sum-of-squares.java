class Solution {
    public long maxAlternatingSum(int[] nums) {
        long answer = 0;
        int n = nums.length, target = n / 2;

        for (int i = 0; i < n; i++) {
            nums[i] *= nums[i];
        }

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i >= target) {
                answer += nums[i];
            } else {
                answer -= nums[i];
            }
        }

        return answer;
    }
}
