class Solution0491 {
public:
    vector<vector<int>> findSubsequences(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> curr;
        dfs(res, 0,  nums,curr);
        return res;
    }

    void dfs(vector<vector<int>>& res, int idx, vector<int>& nums , vector<int>& curr) {
        if (idx >= nums.size()) {
            if (curr.size() >= 2) {
                res.push_back(curr);
            }          
            return;
        }
        if (curr.size() == 0 || nums[idx] >= curr[curr.size()-1]) {
            curr.push_back(nums[idx]);
            dfs(res, idx+1, nums, curr);
            curr.pop_back();
        }
        if (idx > 0 && curr.size() > 0 && nums[idx]==curr[curr.size()-1]) {
            return;
        }
        dfs(res, idx+1, nums, curr);
    }
};