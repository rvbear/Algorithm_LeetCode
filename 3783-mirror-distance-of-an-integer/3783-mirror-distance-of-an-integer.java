class Solution {
    public int mirrorDistance(int n) {
        StringBuilder stb = new StringBuilder(String.valueOf(n));
        int reverseN = Integer.parseInt(stb.reverse().toString());

        return Math.abs(n - reverseN);
    }
}
