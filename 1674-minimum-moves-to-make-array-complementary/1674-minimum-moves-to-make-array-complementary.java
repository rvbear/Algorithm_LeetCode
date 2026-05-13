class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] delta = new int[(limit << 1) + 2];

        for (int i = 0; i < n >> 1; i++) {
            int min = Math.min(nums[i], nums[n - 1 - i]);
            int max = Math.max(nums[i], nums[n - 1 - i]);

            delta[2] += 2;
            delta[min + 1]--;
            delta[min + max]--;
            delta[min + max + 1]++;
            delta[max + limit + 1]++;
        }

        int answer = n, moves = 0;

        for (int i = 2; i <= limit * 2; i++) {
            moves += delta[i];
            answer = Math.min(answer, moves);
        }

        return answer;
    }
}
