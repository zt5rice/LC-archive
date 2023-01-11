public class Solution0606 {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString();
    }
    private void helper(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        if (root.left == null && root.right == null) return;
        
        sb.append("(");
        helper(root.left, sb);
        sb.append(")");
        if (root.right == null) return;
        sb.append("(");
        helper(root.right, sb);
        sb.append(")");
    }    
}
