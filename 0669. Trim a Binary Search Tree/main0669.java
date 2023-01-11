public class main0669 {
    
}
/*
 * Two cases:
 *  1. the root will be deleted
 *  2. the root remains
 */
class Solution0669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return root;
        if (root.val < low) return trimBST(root.right, low, high);        
        if (root.val > high) return trimBST(root.left, low, high);
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}