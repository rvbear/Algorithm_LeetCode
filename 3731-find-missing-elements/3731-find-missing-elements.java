class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> answer = new ArrayList<>();

        Arrays.sort(nums);

        int before = nums[0];
        int n = nums.length;

        for (int i = 1; i < n; before++, i++) {
            if (before + 1 != nums[i]) {
                answer.add(before + 1);
                i--;
            }
        }

        return answer;
    }
}
