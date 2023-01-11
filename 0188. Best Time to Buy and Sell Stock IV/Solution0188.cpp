#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        int n = prices.size();
        if (n == 0) return 0;
        k = min(k, n/2);
        vector<int> buy(k+1, INT_MIN/2);        
        vector<int> sell(k+1, INT_MIN/2);
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < n; i++) {
            buy[0] = max(buy[0], -prices[i]); // !!!!!!!!!!!
            sell[0] = 0; 
            for (int j = 1; j <= k; j++) {
                buy[j] = max(buy[j], sell[j]-prices[i]);
                sell[j] = max(sell[j], buy[j-1]+prices[i]);
            }
        }
        int res = 0;
        for (int i = 0; i <= k; i++) {
            res = max(res, sell[i]);
        }
        return res;
    }
};