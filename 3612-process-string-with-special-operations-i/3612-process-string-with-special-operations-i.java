class Solution {
    public String processStr(String s) {
        StringBuilder stb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '#') {
                stb.append(stb);
            } else if (c == '%') {
                stb.reverse();
            } else if (c == '*') {
                if (stb.length() != 0) {
                    stb.deleteCharAt(stb.length() - 1);
                }
            } else {
                stb.append(c);
            }
        }

        return stb.toString();
    }
}
