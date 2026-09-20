class Solution {
    public int reverseDegree(String s) {
        int sum = 0, index = 1;

        for (char c : s.toCharArray()) {
            int temp = 26 - (c - 'a');
            sum += temp * index++;
        }

        return sum;
    }
}
