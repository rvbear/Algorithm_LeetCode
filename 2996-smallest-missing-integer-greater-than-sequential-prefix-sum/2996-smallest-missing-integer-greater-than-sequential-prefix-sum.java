class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        boolean[] seen = new boolean[52];
        boolean seq = true;

        seen[nums[0]] = true;

        for (int i = 1; i < nums.length; i++) {
            if (seq && nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                seq = false;

                if (sum > 50) {
                    return sum;
                }
            }

            seen[nums[i]] = true;
        }

        for (int i = sum; i < 52; i++) {
            if (!seen[i]) {
                return i;
            }
        }

        return sum;
    }
}
