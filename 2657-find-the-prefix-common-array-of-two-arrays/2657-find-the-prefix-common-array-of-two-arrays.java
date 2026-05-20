class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length, count = 0;
        int[] answer = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[A[i] - 1]) {
                count++;
            } else {
                visited[A[i] - 1] = true;
            }

            if (visited[B[i] - 1]) {
                count++;
            } else {
                visited[B[i] - 1] = true;
            }

            answer[i] = count;
        }

        return answer;
    }
}
