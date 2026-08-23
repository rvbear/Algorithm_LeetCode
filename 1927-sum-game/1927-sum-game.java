class Solution {
    public boolean sumGame(String num) {
        int n = num.length() / 2;
        int left = 0, right = 0;

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);

            int value;

            if (c == '?') {
                value = 9;
            } else {
                value = 2 * (c - '0');
            }

            if (i < n) {
                left += value;
            } else {
                right += value;
            }
        }

        return left != right;
    }
}
