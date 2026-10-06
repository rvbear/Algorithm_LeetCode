class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (open == 0) {
                count++;
            } else {
                open--;
            }
        }

        return open + count;
    }
}
