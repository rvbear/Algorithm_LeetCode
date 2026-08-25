class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] contains = new boolean[201];

        for (int n : nums) {
            contains[n] = true;
        }

        int answer = k;

        while (contains[answer]) {
            answer += k;
        }

        return answer;
    }
}
