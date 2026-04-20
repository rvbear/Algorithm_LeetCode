class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length, max = 0;

        for (int i = 0, j = 1; i < n - 1; j++) {
            if (colors[i] != colors[j]) {
                max = Math.max(max, j - i);
            }

            if (j == n - 1) {
                j--;
                i++;
            }
        }

        return max;
    }
}
