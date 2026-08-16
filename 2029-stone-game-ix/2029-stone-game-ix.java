class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] arr = {0, 0, 0};

        for (int s : stones) {
            arr[s % 3]++;
        }

        if ((arr[0] & 1) == 0) {
            return Math.min(arr[1], arr[2]) > 0;
        }

        return Math.abs(arr[1] - arr[2]) > 2;
    }
}
