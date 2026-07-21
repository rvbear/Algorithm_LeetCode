class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int count1 = 0, block1 = 0, block2 = 0;
        int max = 0, i = 0;

        while (i < n) {
            char c = arr[i];

            if (c == '0') {
                block1++;
                i++;
            } else {
                while (i < n && arr[i] == '1') {
                    i++;
                    count1++;
                }

                while (i < n && arr[i] == '0') {
                    i++;
                    block2++;
                }

                if (block1 != 0 && block2 != 0) {
                    max = Math.max(max, block1 + block2);
                }

                block1 = block2;
                block2 = 0;
            }
        }

        return count1 + max;
    }
}
