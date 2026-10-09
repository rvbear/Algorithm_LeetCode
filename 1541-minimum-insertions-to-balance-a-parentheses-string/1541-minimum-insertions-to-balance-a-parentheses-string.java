class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    if (i < s.length() - 1 && s.charAt(i + 1) == ')') {
                        i++;
                    } else {
                        answer++;
                    }

                    answer++;
                } else {
                    if (i < s.length() - 1 && s.charAt(i + 1) == ')') {
                        i++;
                    } else {
                        answer++;
                    }

                    stack.pop();
                }
            }
        }

        return answer + stack.size() * 2;
    }
}
