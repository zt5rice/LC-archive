#include<iostream>
#include<vector>

using namespace std;

class Solution0980 {
public:
    int uniquePathsIII(vector<vector<int>>& grid) {
        int startR = -1, startC = -1, count0 = 1;
        int rows = grid.size(), cols = grid[0].size();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    startR = i;
                    startC = j;
                }
                if (grid[i][j] == 0) {
                    count0++;
                }
            }
        }
        return dfs(startR, startC, count0, grid); 
    }

    int dfs(int startR, int startC, int count0, vector<vector<int>>& grid) {
        if (startR < 0 || startR >= grid.size() || startC < 0 || startC >= grid[0].size() || grid[startR][startC] == -1) return 0;
        if (grid[startR][startC] == 2) return count0 == 0 ? 1 : 0;
        grid[startR][startC] = -1;
        int res = 0;
        res += dfs(startR+1, startC, count0-1, grid);
        res += dfs(startR, startC+1, count0-1, grid);
        res += dfs(startR, startC-1, count0-1, grid);
        res += dfs(startR-1, startC, count0-1, grid);
        grid[startR][startC] = 0; 
        return res;
    }
};