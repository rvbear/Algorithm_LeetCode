class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int[] row : matrix) {
            int left = 0, right = n - 1, temp;

            while (left < right) {
                temp = row[left];
                row[left] = row[right];
                row[right] = temp;

                left++;
                right--;
            }
        }
    }
}
