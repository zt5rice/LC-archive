class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        stack<TreeNode*> stk;
        stk.push(root);
        stk.push(root);
        while (!stk.empty()) {
            TreeNode* r1 = stk.top(); stk.pop();
            TreeNode* r2 = stk.top(); stk.pop();
            if (r1 == nullptr && r2 == nullptr) continue;
            if (r1 == nullptr || r2 == nullptr || r1->val != r2->val) return false;
            stk.push(r1->left);
            stk.push(r2->right);
            stk.push(r1->right);
            stk.push(r2->left);
        }
        return true;
    }
};

class Solution0101_recursion {
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