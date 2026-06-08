class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length, left = 0, right = n - 1, i = 0, j = n - 1;
        int[] answer = new int[n];

        while (i < n) {
            if (nums[i] < pivot) {
                answer[left++] = nums[i];
            }

            if (nums[j] > pivot) {
                answer[right--] = nums[j];
            }

            i++;
            j--;
        }

        while (left <= right) {
            answer[left++] = pivot;
        }

        return answer;
    }
}
