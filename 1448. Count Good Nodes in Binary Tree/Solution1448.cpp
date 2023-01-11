#include<vector>
#include<iostream>
using namespace std;

class Solution1448 {
public:
    int goodNodes(TreeNode* root) {
        vector<int> count(1,0);
        helper(root, INT_MIN, count);
        return count[0];
    }
    void helper(TreeNode* root, int maxSoFar, vector<int>& count) {
        if (root->val >= maxSoFar) {
            count[0]++;
            maxSoFar = root->val;
        }
        if (root->left) {
            helper(root->left, maxSoFar, count);
        }
        if (root->right) {
            helper(root->right, maxSoFar, count);
        }        
    }
};