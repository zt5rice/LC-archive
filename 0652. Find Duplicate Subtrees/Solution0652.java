class Solution0653 { // 53-09
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> countMap = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        helper(root, countMap, res);
        return res;
    }
    private String helper(TreeNode root, Map<String, Integer> count, List<TreeNode> res) {
        if (root == null) return "N,";
        String curstr = helper(root.right, count, res) + helper(root.left, count, res) +  String.valueOf(root.val) + ",";
        int strCount = count.getOrDefault(curstr,0);
        if (strCount == 1) {
            res.add(root);
        }
        count.put(curstr, strCount+1);
        return curstr;
    }
}