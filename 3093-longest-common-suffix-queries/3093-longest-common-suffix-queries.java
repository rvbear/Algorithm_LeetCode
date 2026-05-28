class Solution {
    class Node {
        Node[] children = new Node[26];
        int bestLen = Integer.MAX_VALUE;
        int bestIndex = Integer.MAX_VALUE;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Node root = new Node();

        for (int i = 0; i < wordsContainer.length; i++) {
            String word = wordsContainer[i];
            int len = word.length();
            Node cur = root;

            if (len < cur.bestLen || (len == cur.bestLen && i < cur.bestIndex)) {
                cur.bestLen = len;
                cur.bestIndex = i;
            }

            for (int j = len - 1; j >= 0; j--) {
                int charIndex = word.charAt(j) - 'a';

                if (cur.children[charIndex] == null) {
                    cur.children[charIndex] = new Node();
                }

                cur = cur.children[charIndex];

                if (len < cur.bestLen || (len == cur.bestLen && i < cur.bestIndex)) {
                    cur.bestLen = len;
                    cur.bestIndex = i;
                }
            }
        }

        int[] answer = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            String query = wordsQuery[i];
            int len = query.length();
            Node cur = root;

            for (int j = len - 1; j >= 0; j--) {
                int charIndex = query.charAt(j) - 'a';

                if (cur.children[charIndex] == null) {
                    break;
                }

                cur = cur.children[charIndex];
            }

            answer[i] = cur.bestIndex;
        }

        return answer;
    }
}
