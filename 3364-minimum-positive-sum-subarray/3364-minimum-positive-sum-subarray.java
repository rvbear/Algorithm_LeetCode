class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int[] prefix = new int[nums.size() + 1];

        for (int i = 0; i < nums.size(); i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.size(); i++) {
            for (int len = l; len <= r; len++) {
                int j = i + len;
                
                if (j > prefix.length - 1) {
                    break;
                }

                int sum = prefix[j] - prefix[i];
                
                if (sum > 0) {
                    answer = Math.min(answer, sum);
                }
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
