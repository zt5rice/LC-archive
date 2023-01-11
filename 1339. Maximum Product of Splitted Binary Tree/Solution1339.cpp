class Solution1339 {
public:
    int maxProduct(TreeNode* root) {
        vector<int> sumList;
        int MOD = 1000000007;
        int totSum = helper(root, sumList);
        long res = 0;
        for (int curSum : sumList) {
            res = max(res, (long)curSum*(totSum - curSum));
        }
        return (int) (res % MOD);
    }

    int helper(TreeNode* root, vector<int>& sumList) {
        if (root == nullptr) {
            return 0;
        }
        int left = helper(root->left, sumList);
        int right = helper(root->right, sumList);
        int curSum = left + right + root->val;
        sumList.push_back(curSum);
        return curSum;
    }
};