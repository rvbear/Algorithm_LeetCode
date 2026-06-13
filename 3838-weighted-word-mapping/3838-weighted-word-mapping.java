class Solution {
    private static final int MOD = 26;

    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder stb = new StringBuilder();

        for (String word : words) {
            int sum = 0;

            for (char c : word.toCharArray()) {
                sum += weights[c - 'a'];
            }

            stb.append((char) ('z' - (sum % MOD)));
        }

        return stb.toString();
    }
}
