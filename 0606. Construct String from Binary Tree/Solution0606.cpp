#include<string.h>
#include<iostream>
using namespace std;

class Solution0606 {
public:
    string tree2str(TreeNode* root) {
        if (root == nullptr) return "";
        string res = to_string(root->val);
        string left = tree2str(root->left);        
        string right = tree2str(root->right);
        if (left.length() != 0 || right.length() != 0) {
            res += "(";
            res += left;
            res += ")";
        }
        if (right.length() != 0) {
            res += "(";
            res += right;
            res += ")";            
        }
        return res;
    }
};