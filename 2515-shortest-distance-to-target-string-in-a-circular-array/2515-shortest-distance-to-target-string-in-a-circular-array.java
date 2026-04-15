class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length, min = Integer.MAX_VALUE;

        for (int i = startIndex; i < n + startIndex; i++) {
            if (words[i % n].equals(target)) {
                min = i - startIndex;
                break;
            }
        }

        for (int i = n + startIndex; i > startIndex; i--) {
            if (words[i % n].equals(target)) {
                min = Math.min(n + startIndex - i, min);
                break;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
