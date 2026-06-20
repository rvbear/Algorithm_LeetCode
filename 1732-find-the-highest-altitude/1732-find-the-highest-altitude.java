class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length, max = 0;
        int[] arr = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            arr[i] = arr[i - 1] + gain[i - 1];
            max = Math.max(arr[i], max);
        }

        return max;
    }
}
