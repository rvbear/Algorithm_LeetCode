class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] alphabets = new int[26];

        for (char c : text.toCharArray()) {
            alphabets[c - 'a']++;
        }

        int min = Integer.MAX_VALUE;

        min = Math.min(min, alphabets['b' - 'a']);
        min = Math.min(min, alphabets['a' - 'a']);
        min = Math.min(min, alphabets['l' - 'a'] / 2);
        min = Math.min(min, alphabets['o' - 'a'] / 2);
        min = Math.min(min, alphabets['n' - 'a']);

        return min;
    }
}
