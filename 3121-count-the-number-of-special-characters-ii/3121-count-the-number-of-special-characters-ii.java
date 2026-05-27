class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lastLow = new int[26];
        int[] firstUp = new int[26];

        Arrays.fill(lastLow, -1);
        Arrays.fill(firstUp, -1);

        Set<Integer> invalid = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c >= 'a' && c <= 'z') {
                int index = c - 'a';
                lastLow[index] = i;

                if (firstUp[index] != -1) {
                    invalid.add(index);
                }
            } else {
                int index = c - 'A';

                if (firstUp[index] == -1) {
                    firstUp[index] = i;
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < 26; i++) {
            if (lastLow[i] != -1 && firstUp[i] != -1 && !invalid.contains(i)) {
                answer++;
            }
        }

        return answer;
    }
}
