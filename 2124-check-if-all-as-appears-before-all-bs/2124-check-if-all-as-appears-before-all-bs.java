class Solution {
    public boolean checkString(String s) {
        int aCount = 0, bCount = 0;

        for (char c : s.toCharArray()) {
            if (c == 'a') {
                if (bCount > 0) {
                    return false;
                }

                aCount++;
            } else if (c == 'b') {
                bCount++;
            }
        }

        return true;
    }
}
