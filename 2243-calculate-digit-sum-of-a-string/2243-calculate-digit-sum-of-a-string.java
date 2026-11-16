class Solution {
    public String digitSum(String s, int k) {
        String answer = s;

        while (answer.length() > k) {
            String temp = answer;
            answer = "";

            for (int i = 0; i < temp.length(); i += k) {
                int val = 0;

                for (char c : temp.substring(i, Math.min(i + k, temp.length())).toCharArray()) {
                    val += c - '0';
                }

                answer += val;
            }
        }

        return answer;
    }
}
