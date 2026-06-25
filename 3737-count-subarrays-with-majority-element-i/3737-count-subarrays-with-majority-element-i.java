class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length, pos = n + 1, len = 2 * n + 2, count = 0;
        int[] freq = new int[len];
        int[] cum = new int[len];
        freq[pos] = cum[pos] = 1;

        for (int num : nums) {
            int offset = (num == target) ? 1 : -1;
            pos += offset;
            freq[pos]++;
            cum[pos] = cum[pos - 1] + freq[pos];
            count += cum[pos - 1];
        }

        return count;
    }
}
