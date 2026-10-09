class Solution {
    public int minInsertions(String s) {
        int open = 0, answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                if (i + 1 < s.length() &&  s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    answer++;
                }
            
                if (open > 0) {
                    open--;
                } else {
                    answer++;
                }
            }
        }

        answer += 2 * open;

        return answer;
    }
}
