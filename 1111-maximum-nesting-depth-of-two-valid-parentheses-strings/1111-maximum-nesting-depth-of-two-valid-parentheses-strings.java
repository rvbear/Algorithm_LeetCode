class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length(), d = 0, index = 0;
        int[] answer = new int[n];

        for (char c : seq.toCharArray()) {
            if (c == '(') {
                d++;
                answer[index++] = (d % 2 == 0) ? 0 : 1;
            } else {
                answer[index++] = d % 2 == 0 ? 0 : 1;
                d--;
            }
        }

        return answer;
    }
}
