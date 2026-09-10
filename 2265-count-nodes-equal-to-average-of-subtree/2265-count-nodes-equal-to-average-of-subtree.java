class Solution {
    int count = 0;

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int subtreeSum = left[0] + right[0] + root.val;
        int subtreeCount = left[1] + right[1] + 1;

        if (subtreeSum / subtreeCount == root.val) {
            count++;
        }

        return new int[] {subtreeSum, subtreeCount};
    }

    public int averageOfSubtree(TreeNode root) {
        dfs(root);

        return count;
    }
}
