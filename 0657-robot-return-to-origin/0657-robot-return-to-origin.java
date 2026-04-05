class Solution {
    public boolean judgeCircle(String moves) {
        int[] val = new int[26];
        
        for (int i = 0; i < moves.length(); i++) {
            val[moves.charAt(i) - 'A']++;
        }

        return val['L' - 'A'] == val['R' - 'A'] && val['U' - 'A'] == val['D' - 'A'];
    }
}