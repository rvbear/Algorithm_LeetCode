class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] arr = new int[51];

        for (int i = 0; i < nums.length - k + 1; i++) {
            boolean[] seen = new boolean[51];

            for (int j = i; j < i + k; j++) {
                if (!seen[nums[j]]) {
                    arr[nums[j]]++;
                    seen[nums[j]] = true;
                }
            }
        }

        for (int i = 50; i > -1; i--) {
            if (arr[i] == 1) {
                return i;
            }
        }

        return -1;
    }
}
