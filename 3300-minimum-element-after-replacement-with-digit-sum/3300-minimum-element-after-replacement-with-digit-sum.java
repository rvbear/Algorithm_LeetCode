class Solution {
    public int minElement(int[] nums) {
        int n = nums.length, answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int num = nums[i], sum = 0;

            while (num > 9) {
                sum += num % 10;
                num /= 10;
            }

            sum += num;

            answer = Math.min(answer, sum);
        }

        return answer;
    }
}
