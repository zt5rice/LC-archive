class Solution0787 {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        vector<int> dp(n, INT_MAX/2);
        dp[src] = 0;
        for (int i = 0; i < k + 1; i++) {
            vector<int> temp(n);
            copy(dp.begin(), dp.end(), temp.begin());
            for (auto flight : flights) {
                dp[flight[1]] = min(temp[flight[0]] + flight[2], dp[flight[1]]);
            }
        }
        if (dp[dst] != INT_MAX/2) {
            return dp[dst];
        }
        return -1;
    }
};