class Solution {
    public int minimumPushes(String word) {
        int answer = 0;

        for (int i = 0; i < word.length(); i++) {
            answer += (i / 8) + 1;
        }

        return answer;
    }
}
