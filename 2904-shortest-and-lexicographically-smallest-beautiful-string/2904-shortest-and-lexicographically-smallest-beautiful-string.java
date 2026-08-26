class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String answer = "";
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int oneCount = 0;
            StringBuilder sb = new StringBuilder();

            for (int j = i; j < n; j++) {
                sb.append(s.charAt(j));

                if (s.charAt(j) == '1') {
                    oneCount++;
                }

                if (oneCount > k) {
                    break;
                }

                if (oneCount == k) {
                    String curStr = sb.toString();

                    if (answer.isEmpty() ||
                        curStr.length() < answer.length() ||
                        (curStr.length() == answer.length() &&
                        curStr.compareTo(answer) < 0)) {
                            answer = curStr;
                    }
                }
            }
        }

        return answer;
    }
}
