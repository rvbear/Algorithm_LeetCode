class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : target.toCharArray()) {
            count[c - 'a']--;
        }

        for (int i = target.length() - 1; i >= 0; i--) {
            int cur = target.charAt(i) - 'a';
            count[cur]++;

            boolean flag = true;

            for (int x : count) {
                if (x < 0) {
                    flag = false;
                    break;
                }
            }

            if (!flag) {
                continue;
            }

            int next = -1;

            for (int c = cur + 1; c < 26; c++) {
                if (count[c] > 0) {
                    next = c;
                    break;
                }
            }

            if (next == -1) {
                continue;
            }

            count[next]--;

            StringBuilder sb = new StringBuilder(target.substring(0, i));
            sb.append((char) ('a' + next));

            for (int c = 0; c < 26; c++) {
                while (count[c]-- > 0) {
                    sb.append((char) ('a' + c));
                }
            }

            return sb.toString();
        }

        return "";
    }
}
