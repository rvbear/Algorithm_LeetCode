class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);

        while (!q.isEmpty()) {
            int nowIndex = q.poll();
            
            if (nowIndex < 0 || nowIndex >= n || visited[nowIndex]) {
                continue;
            }

            if (arr[nowIndex] == 0) {
                return true;
            }

            visited[nowIndex] = true;
            q.offer(nowIndex + arr[nowIndex]);
            q.offer(nowIndex - arr[nowIndex]);
        }

        return false;
    }
}
