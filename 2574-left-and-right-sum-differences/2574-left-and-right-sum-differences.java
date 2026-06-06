class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + nums[i - 1];
        }

        int temp = 0;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] = Math.abs(answer[i] - temp);
            temp += nums[i];
        }

        return answer;
    }
}
