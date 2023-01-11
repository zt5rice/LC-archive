#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;


class Solution0122 {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<vector<int>> dp(2, vector<int>(2,0));
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i%2][0] = max(dp[(i-1)%2][0], dp[(i-1)%2][1] + prices[i]);
            dp[i%2][1] = max(dp[(i-1)%2][1], dp[(i-1)%2][0] - prices[i]);
        }
        return dp[(n-1)%2][0];     
    }
};
