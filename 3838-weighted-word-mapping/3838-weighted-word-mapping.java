class Solution {
    private static final int MOD = 26;

    public String mapWordWeights(String[] words, int[] weights) {
        String answer = "";

        for (String word : words) {
            int sum = 0;

            for (char c : word.toCharArray()) {
                sum += weights[c - 'a'];
            }

            answer += (char) ('z' - (sum % MOD));
        }

        return answer;
    }
}
