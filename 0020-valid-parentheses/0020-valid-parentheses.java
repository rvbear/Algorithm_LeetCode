class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        char[] arr = s.toCharArray();
        int i = 0;

        for (char c : arr) {
            if ((c & 3) != 1) {
                arr[i++] = c;
            } else if (i == 0 || ((c - arr[--i] + 1) >> 1) != 1) {
                return false;
            }
        }

        return i == 0;
    }
}
