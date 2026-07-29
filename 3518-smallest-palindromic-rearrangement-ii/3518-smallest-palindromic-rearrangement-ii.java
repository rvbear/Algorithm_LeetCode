class Solution {
    private final static long TOP = 3_000_000_000L;

    private long countArrangements(int[] count, int total) {
        long result = 1;
        int remaining = total;

        for (int i = 0; i < 26 && result <= TOP; i++) {
            int c = count[i];
            long comb = 1;

            for (int j = 1; j <= c; j++) {
                comb = comb * (remaining - c + j) / j;

                if (comb > TOP) {
                    comb = TOP + 1;
                    break;
                }
            }

            result *= comb;

            if (result > TOP) {
                result = TOP + 1;
                break;
            }

            remaining -= c;
        }

        return result;
    }

    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int oddIndex = -1;

        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddIndex = i;
            }
        }

        int[] half = new int[26];
        int halfLen = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = count[i] / 2;
            halfLen += half[i];
        }

        long total = countArrangements(half, halfLen);

        if (total < k) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        long remainingK = k;
        int remaining = halfLen;

        for (int i = 0; i < halfLen; i++) {
            for (int j = 0; j < 26; j++) {
                if (half[j] == 0) {
                    continue;
                }

                half[j]--;

                long arrangements = countArrangements(half, remaining - 1);

                if (remainingK <= arrangements) {
                    sb.append((char) ('a' + j));
                    break;
                } else {
                    remainingK -= arrangements;
                    half[j]++;
                }
            }

            remaining--;
        }

        String halfStr = sb.toString();
        StringBuilder full = new StringBuilder(halfStr);

        if (oddIndex != -1) {
            full.append((char) ('a' + oddIndex));
        }

        full.append(new StringBuilder(halfStr).reverse());

        return full.toString();
    }
}
