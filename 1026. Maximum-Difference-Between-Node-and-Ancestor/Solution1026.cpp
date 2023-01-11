class Solution1026 {
public:
    int maxAncestorDiff(TreeNode* root) {
        return helper(root, root->val, root->val);
    }
    int helper(TreeNode* root, int minVal, int maxVal) {
        if (root == nullptr) {
            return maxVal - minVal;
        }
        minVal = min(minVal, root->val);
        maxVal = max(maxVal, root->val);
        int left = helper(root->left, minVal, maxVal);
        int right = helper(root->right, minVal, maxVal);
        return max(left, right);
    }
};