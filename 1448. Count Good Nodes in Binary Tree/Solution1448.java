class Solution1448 {
    private int numGoodNodes = 0;
    
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return numGoodNodes;
    }
    
    private void dfs(TreeNode node, int maxSoFar) {
        if (maxSoFar <= node.val) {
            numGoodNodes++;
        }
        if (node.left != null) {
            dfs(node.left, Math.max(node.val, maxSoFar));
        }
        if (node.right != null) {
            dfs(node.right, Math.max(node.val, maxSoFar));
        }
    }
}