class Solution {
    private void processRow(char[][] rotateGrid, char[] row, int x) {
        int lowest = row.length;

        for (int i = row.length - 1; i >= 0; i--) {
            if (row[i] == '#') {
                lowest -= 1;
                rotateGrid[lowest][x] = '#';

                if (lowest != i) {
                    rotateGrid[i][x] = '.';
                }
            } else if (row[i] == '*') {
                lowest = i;
                rotateGrid[lowest][x] = '*';
            } else {
                rotateGrid[i][x] = '.';
            }
        }
    }

    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length, n = boxGrid[0].length;
        char[][] answer = new char[n][m];

        for (int i = 0; i < m; i++) {
            processRow(answer, boxGrid[i], m - 1 - i);
        }

        return answer;
    }
}
