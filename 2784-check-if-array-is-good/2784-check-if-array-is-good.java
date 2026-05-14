class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length, target = 1;
        
        Arrays.sort(nums);

        for (int i = 0; i < n - 1; i++) {
            System.out.println(nums[i]);
            
            if (target != nums[i]) {
                return false;
            }

            target++;
        }
        
        return --target == nums[n - 1];
    }
}
