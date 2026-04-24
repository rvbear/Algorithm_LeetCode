class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();
        int count = 0, extra = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                count--;
            } else if (c == 'R') {
                count++;
            } else {
                extra++;
            }
        }

        return Math.max(Math.abs(count - extra), Math.abs(count + extra));
    }
}
