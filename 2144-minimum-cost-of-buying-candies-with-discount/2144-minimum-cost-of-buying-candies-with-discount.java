class Solution {
    public int minimumCost(int[] cost) {
        cost = Arrays.stream(cost)
                    .boxed()
                    .sorted(Collections.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();
        int answer = 0, index = 0;

        for (int c : cost) {
            if (index % 3 != 2) {
                answer += c;
            }

            index++;
        }

        return answer;
    }
}
