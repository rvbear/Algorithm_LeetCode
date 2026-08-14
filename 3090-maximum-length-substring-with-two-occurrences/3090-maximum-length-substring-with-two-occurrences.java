class Solution {
    public int maximumLengthSubstring(String s) {
        int answer = 0;
        int[] count = new int[26];

        for (int i = 0, j = 0; j < s.length(); j++) {
            count[(s.charAt(j) & 31) - 1]++;

            while (count[(s.charAt(j) & 31) - 1] > 2) {
                count[(s.charAt(i++) & 31) - 1]--;
            }

            answer = Math.max(answer, j - i + 1);
        }

        return answer;
    }
}
