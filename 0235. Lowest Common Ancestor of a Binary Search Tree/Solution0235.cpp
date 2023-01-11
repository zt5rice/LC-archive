
# include<iostream>
using namespace std;

 struct TreeNode {
     int val;
    TreeNode *left;
     TreeNode *right;
     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 };
 

class Solution {
public:
    TreeNode* lowestCommonAncestor0(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root->val > p->val && root->val > q->val) {
            return lowestCommonAncestor(root->left, p, q);
        }
        if (root->val < p->val && root->val < q->val) {
            return lowestCommonAncestor(root->right, p, q);
        }
        return root;
    }
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        TreeNode* cur = root;
        while (cur != nullptr) {
            if (cur->val > p->val && cur->val > q->val) {
                cur = cur->left;
            } else if (cur->val < p->val && cur->val < q->val) {
                cur = cur->right;
            } else {
                return cur;
            }
        }
        return nullptr;
    }
};