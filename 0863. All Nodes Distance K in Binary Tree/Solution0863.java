public class Solution0863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        helper(root, target, k, res);
        return res;
    }
    
    private int helper(TreeNode root, TreeNode target, int k, List<Integer> res) {
        if (root == null) return -1;
        if (root.val == target.val) {collect(root, k, res); return 0;}
        int left = helper(root.left, target, k, res);
        int right = helper(root.right, target, k, res);
        if (left >= 0) {
            if (left == k-1) res.add(root.val);
            collect(root.right, k - left - 2, res);
            return left + 1;
        }
        if (right >= 0) {
            if (right == k-1) res.add(root.val);
            collect(root.left, k - right - 2, res);
            return right + 1;
        }
        return -1;
    }
    
    private void collect(TreeNode root, int d, List<Integer> res) {
        if (root == null || d < 0) return;
        if (d == 0) res.add(root.val);
        collect(root.left, d-1, res);        
        collect(root.right, d-1, res);
    }
}
// inspired by Huahua cpp solution, recursion tc/sc: o(n)