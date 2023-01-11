class Solution1457 {
    int count = 0;
    
    public int pseudoPalindromicPaths (TreeNode root) {
        if (root == null) return 0;
        helper(root, 0);
        return count;
    }

    private void helper(TreeNode root, int num) {
        int cur = num ^ (1 << root.val);

        if (root.left == null && root.right == null) {
            if (cur == 0 || (cur & (cur-1)) == 0) {
                ++count;
            } 
        }
        if (root.left != null) {
            helper(root.left, cur);
        }
        if (root.right != null) {
            helper(root.right, cur);
        }
    }
}


// 作者：dnanki
// 链接：https://leetcode.cn/problems/pseudo-palindromic-paths-in-a-binary-tree/solution/wei-yun-suan-jie-fa-by-dnanki/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。