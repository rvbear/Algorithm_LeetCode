class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length, l = 0, sum = 0;
        int answer = Integer.MAX_VALUE, best = Integer.MAX_VALUE;
        int[] minLen = new int[n];

        for (int r = 0; r < n; r++) {
            sum += arr[r];

            while (sum > target) {
                sum -= arr[l++];
            }

            if (sum == target) {
                int curLen = r - l + 1;

                if (l > 0 && minLen[l - 1] != Integer.MAX_VALUE) {
                    answer = Math.min(answer, curLen + minLen[l - 1]);
                }

                best = Math.min(best, curLen);
            }

            minLen[r] = best;
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
