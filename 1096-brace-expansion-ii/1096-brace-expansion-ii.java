class Solution {
    private void merge(List<List<String>> groups, List<String> group) {
        if (groups.get(groups.size() - 1).isEmpty()) {
            groups.set(groups.size() - 1, group);
            return;
        }

        List<String> mergedGroup = new ArrayList<>();

        for (String word1 : groups.get(groups.size() - 1)) {
            for (String word2 : group) {
                mergedGroup.add(word1 + word2);
            }
        }

        groups.set(groups.size() - 1, mergedGroup);
    }

    private List<String> dfs(String expression, int s, int e) {
        TreeSet<String> answer = new TreeSet<>();
        List<List<String>> groups = new ArrayList<>();

        groups.add(new ArrayList<>());

        int layer = 0, left = 0;

        for (int i = s; i <= e; i++) {
            if (expression.charAt(i) == '{' && ++layer == 1) {
                left = i + 1;
            } else if (expression.charAt(i) == '}' && --layer == 0) {
                merge(groups, dfs(expression, left, i - 1));
            } else if (expression.charAt(i) == ',' && layer == 0) {
                groups.add(new ArrayList<>());
            } else if (layer == 0) {
                merge(groups, new ArrayList<>(List.of(String.valueOf(expression.charAt(i)))));
            }
        }

        for (List<String> group : groups) {
            for (String word : group) {
                answer.add(word);
            }
        }

        return new ArrayList<>(answer);
    }

    public List<String> braceExpansionII(String expression) {
        return dfs(expression, 0, expression.length() - 1);
    }
}
