#include<iostream>
#include<vector>

using namespace std;

class Solution0329 {
public:
    int DIRS[4][2] = {{0,1},{1,0},{0,-1},{-1,0}};    
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        int row = matrix.size(), col = matrix[0].size();
        int longest = 0;        
        vector<vector<int>> dp(row, vector<int>(col));
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                longest = max(longest, dfs(i, j, dp, matrix)); //
            }
        }    
        return longest;
    }
    
    int dfs(int r, int c, vector<vector<int>>& dp, vector<vector<int>>& matrix) {
        int row = matrix.size(), col = matrix[0].size();
        if (dp[r][c] != 0) return dp[r][c];
        int res = 0;
        for (auto dir : DIRS) {
            int nr = r + dir[0], nc = c + dir[1];
            if (nr >= 0 && nr < row && nc >= 0 && nc < col && matrix[nr][nc] < matrix[r][c]) {
                res = max(res, dfs(nr, nc, dp, matrix));
            }
        }
        dp[r][c] = res + 1;
        return dp[r][c];
    }
};