class Solution {
    private void bwd(String s, List<String> answer, int ri, int rj) {
        int bal = 0;

        for (int i = ri; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                bal++;
            }

            if (s.charAt(i) == '(') {
                bal--;
            }

            if (bal >= 0) {
                continue;
            }

            for (int j = rj; j >= i; j--) {
                if (s.charAt(j) == '(' && (i == rj || s.charAt(j + 1) != '(')) {
                    bwd(s.substring(0, j) + s.substring(j + 1), answer, i - 1, j - 1);
                }
            }

            return;
        }

        answer.add(s);
    }

    private void fwd(String s, List<String> answer, int li, int lj) {
        int bal = 0;

        for (int i = li; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                bal++;
            }

            if (s.charAt(i) == ')') {
                bal--;
            }

            if (bal >= 0) {
                continue;
            }

            for (int j = lj; j <= i; j++) {
                if (s.charAt(j) == ')' && (j == lj || s.charAt(j - 1) != ')')) {
                    fwd(s.substring(0, j) + s.substring(j + 1), answer, i, j);
                }
            }

            return;
        }

        bwd(s, answer, s.length() - 1, s.length() - 1);
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> answer = new ArrayList<>();

        fwd(s, answer, 0, 0);

        return answer;
    }
}
