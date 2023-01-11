#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

class Solution0121 {
public:
    int maxProfit(vector<int>& prices) {
        int maxProf = 0;
        int n = prices.size();
        int minCost = INT_MAX;
        for (int i = 0; i < n; i++) {
            if (prices[i] <= minCost) {
                minCost = prices[i];
            } else {
                maxProf = max(maxProf, prices[i] - minCost);
            }
        }
        return maxProf;
    }
};