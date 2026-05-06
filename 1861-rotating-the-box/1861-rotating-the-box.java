class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length, n = boxGrid[0].length;
        char[][] answer = new char[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer[j][m - 1 - i] = boxGrid[i][j];
            }
        }

        int[] emptyIndex = new int[m];
        Arrays.fill(emptyIndex, n - 1);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (answer[i][j] == '#') {
                    if (emptyIndex[j] != i) {
                        answer[emptyIndex[j]][j] = '#';
                        answer[i][j] = '.';
                    }

                    emptyIndex[j]--;
                } else if (answer[i][j] == '*') {
                    emptyIndex[j] = i - 1;
                }
            }
        }

        return answer;
    }
}
