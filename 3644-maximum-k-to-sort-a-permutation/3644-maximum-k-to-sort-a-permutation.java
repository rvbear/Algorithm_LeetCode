class Solution {
    public int sortPermutation(int[] nums) {
        int answer = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                if (answer == -1) {
                    answer = nums[i];
                } else {
                    answer &= nums[i];
                }
            }
        }

        return answer == -1 ? 0 : answer;
    }
}
