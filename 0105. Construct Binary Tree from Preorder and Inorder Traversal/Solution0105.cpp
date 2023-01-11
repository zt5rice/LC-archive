class Solution0105 {
public:
    int preorderIdx;
    unordered_map<int, int> inMap;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
       for (int i = 0; i < inorder.size(); i++) {
           inMap[inorder[i]] = i;
       }
       preorderIdx = 0;
       return helper(preorder, 0, preorder.size() - 1);        
    }
    
    TreeNode* helper(vector<int>& preorder, int left, int right) {
        if (left>right) return nullptr;
        int rootVal = preorder[preorderIdx++];
        TreeNode* root = new TreeNode(rootVal);
        root->left = helper(preorder, left, inMap[rootVal]-1);
        root->right = helper(preorder, inMap[rootVal]+1, right);
        return root;
    }
};
