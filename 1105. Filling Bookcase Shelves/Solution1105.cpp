#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

class Solution1105 {
public:
    int minHeightShelves(vector<vector<int>>& books, int shelfWidth) {
        int n = books.size();
        int INF = INT_MAX / 2;
        vector<int>dp(n+1,INF);
        dp[0] = 0;
        dp[1] = books[0][1];
        for (int i = 2; i <= books.size(); i++) {
            int curWid = 0;
            int curHeight = 0;
            for (int j = i-1; j >= 0; j--) {
                curWid += books[j][0];
                curHeight = max(curHeight, books[j][1]);
                if (curWid > shelfWidth) break;
                dp[i] = min(dp[i], dp[j] + curHeight);
            }
        }
        return dp[n];        
    }
};