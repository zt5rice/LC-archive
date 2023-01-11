class Solution0312 {
public:
    int maxCoins(vector<int>& nums) {
        int n = nums.size();
        vector<int> val(n+2, 0);
        for (int i = 1; i < n+1; i++) {
            val[i] = nums[i-1];
        }
        val[0] = val[n+1] = 1;
        vector<vector<int>> dp(n+2, vector<int>(n+2, 0));
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+2; j < n+2; j++) {
                for (int k = i+1; k < j; k++) {
                    int tmp = val[i] * val[j] * val[k];
                    tmp += dp[i][k] + dp[k][j];
                    dp[i][j] = max(dp[i][j], tmp);
                }
            }
        }
        return dp[0][n+1];
    }
};