#include<iostream>
#include<vector>
#include<string>

using namespace std;

class Solution0132 {
public:
    int minCut(string s) {
        vector<int> dp(s.length(), 0);
        for (int i = 1; i < s.length(); i++) {
            dp[i] = i;
        }
        for (int mid = 0; mid < s.length(); mid++) {
            helper(s, mid-1, mid, dp);            
            helper(s, mid, mid, dp);
        }
        return dp[s.length() - 1];
    }
    
    void helper(string s, int left, int right, vector<int>& dp) {
        while (left >= 0 && right < s.length() && s[left] == s[right]) {
            int rangeMinCut = left == 0 ? 0 : dp[left-1] + 1;
            dp[right] = min(dp[right], rangeMinCut);
            left--; right++;
        }
    }
};