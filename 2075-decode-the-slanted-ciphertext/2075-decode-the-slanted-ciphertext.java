class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) {
            return encodedText;
        }

        int len = encodedText.length();
        int cols = len / rows;
        StringBuilder ans = new StringBuilder(len);

        for (int c = 0; c < cols; c++) {
            int r = 0, j = c;

            while (r < rows && j < cols) {
                ans.append(encodedText.charAt(r * cols + j));
                r++;
                j++;
            }
        }

        int end = ans.length() - 1;

        while (end >= 0 && ans.charAt(end) == ' ') {
            end--;
        }

        return ans.substring(0, end + 1);
    }
}
