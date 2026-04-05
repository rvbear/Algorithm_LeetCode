class Solution {
    public boolean judgeCircle(String moves) {
        int leftCount = 0, upCount = 0;

        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'L') {
                leftCount++;
            } else if (moves.charAt(i) == 'R') {
                leftCount--;
            } else if (moves.charAt(i) == 'U') {
                upCount++;
            } else if (moves.charAt(i) == 'D') {
                upCount--;
            }
        }

        return leftCount == 0 && upCount == 0;
    }
}