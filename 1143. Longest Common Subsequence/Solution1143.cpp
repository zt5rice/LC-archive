class Solution1143 {
public:
    int longestCommonSubsequence(string text1, string text2) {
        int n1 = text1.length(), n2 = text2.length();
        vector<vector<int>> dp(n1+1, vector<int>(n2+1, 0));
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (text1[i] == text2[j]) {
                    dp[i+1][j+1] = max(dp[i+1][j+1], dp[i][j] + 1);
                } else {
                    dp[i+1][j+1] = max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[n1][n2];
    }
};