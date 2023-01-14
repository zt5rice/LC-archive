class Solution0101 {
public:
    bool isSymmetric(TreeNode* root) {
        return isSym(root, root);
    }

    bool isSym(TreeNode* r1, TreeNode* r2) {
        if (r1 == nullptr && r2 == nullptr) {
            return true;
        } else if (r1 == nullptr || r2 == nullptr) {
            return false;
        } else if (r1->val != r2->val) {
            return false;
        }
        return (isSym(r1->left, r2->right) && isSym(r1->right, r2->left));
    }
};