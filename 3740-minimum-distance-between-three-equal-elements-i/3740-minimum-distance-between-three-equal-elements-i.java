class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length, min = Integer.MAX_VALUE;

        if (n < 3) {
            return -1;
        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[i] == nums[j]) {
                    for (int k = j + 1; k < n; k++) {
                        if (nums[j] == nums[k]) {
                            min = Math.min(min, k - i);
                            break;
                        }
                    }
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min * 2;
    }
}