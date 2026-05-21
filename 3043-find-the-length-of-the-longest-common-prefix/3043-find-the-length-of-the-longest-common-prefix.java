class Solution {
    private int digits(int x) {
        int count = 0;

        while (x > 0) {
            count++;
            x /= 10;
        }

        return count;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefixes = new HashSet<>();

        for (int num : arr1) {
            int x = num;

            while (x > 0) {
                prefixes.add(x);
                x /= 10;
            }
        }

        int answer = 0;

        for (int num : arr2) {
            int x = num;
            int len = digits(num);

            while (x > 0) {
                if (prefixes.contains(x)) {
                    answer = Math.max(answer, len);
                    break;
                }

                x /= 10;
                len--;
            }
        }

        return answer;
    }
}
