class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0, temp = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            temp += i * nums[i];
        }

        int max = temp;

        for (int i = 1; i < n; i++) {
            temp += sum - n * nums[n - i];
            max = Math.max(max, temp);
        }

        return max;
    }
}
