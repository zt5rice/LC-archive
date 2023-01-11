class Solution1457 {
public:
    int count = 0;
    int pseudoPalindromicPaths (TreeNode* root) {
        if (root == nullptr) return 0;
        helper(root, 0);
        return count;        
    }

private:
    void helper(TreeNode* root, int num) {
        int cur = num ^ (1 << root->val);

        if (root->left == nullptr && root->right == nullptr) {
            if (cur == 0 || (cur & (cur-1)) == 0) {
                ++count;
            } 
        }
        if (root->left != nullptr) {
            helper(root->left, cur);
        }
        if (root->right != nullptr) {
            helper(root->right, cur);
        }
    }
};