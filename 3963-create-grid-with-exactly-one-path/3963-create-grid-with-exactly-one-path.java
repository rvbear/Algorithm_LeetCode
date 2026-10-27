class Solution {
    public String[] createGrid(int m, int n) {
        String[] answer = new String[m];

        Arrays.fill(answer, 0, m - 1, "." + "#".repeat(n - 1));
        answer[m - 1] = ".".repeat(n);

        return answer;
    }
}
