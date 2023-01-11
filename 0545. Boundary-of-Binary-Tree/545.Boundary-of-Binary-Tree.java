/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> boundary = new ArrayList<>();
        if (root == null) return boundary;
        boundary.add(root.val);
        findLeftBoundary(root.left, boundary);
        if (root.left != null || root.right != null) findLeaves(root, boundary);
        findRightBoundary(root.right, boundary);
        return boundary;
    }

    private void findLeftBoundary(TreeNode root, List<Integer> boundary) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        boundary.add(root.val);
        if (root.left == null) {
            findLeftBoundary(root.right, boundary);
        } else {
            findLeftBoundary(root.left, boundary);
        }

    }
    private void findLeaves(TreeNode root, List<Integer> boundary) {
        if (root == null) return;
        if (root.left == null && root.right == null) boundary.add(root.val);
        findLeaves(root.left, boundary);
        findLeaves(root.right, boundary);
    }
    private void findRightBoundary(TreeNode root, List<Integer> boundary) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        if (root.right == null) {
            findRightBoundary(root.left, boundary);
        } else {
            findRightBoundary(root.right, boundary);
        }
        boundary.add(root.val);
    }
}