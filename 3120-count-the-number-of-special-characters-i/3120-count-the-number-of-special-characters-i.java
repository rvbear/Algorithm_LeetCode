class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lowCase = new int[26];
        int[] upCase = new int[26];

        for (char c : word.toCharArray()) {
            int val = c - 'A';

            if (val < 27) {
                lowCase[val]++;
            } else {
                upCase[c - 'a']++;
            }
        }

        int answer = 0;

        for (int i = 0; i < 26; i++) {
            if (lowCase[i] > 0 && upCase[i] > 0) {
                answer++;
            }
        }

        return answer;
    }
}
