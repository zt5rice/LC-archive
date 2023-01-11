class Solution1292 {
public:
    int maxSideLength(vector<vector<int>>& mat, int threshold) {
        int r = mat.size(), c = mat[0].size();
        vector<vector<int>> sum(r+1, vector<int>(c+1,0));
        int res = 0, next = 1;
        for (int i = 1; i < r+1; i++) {
            for (int j = 1; j < c+1; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + mat[i-1][j-1];
                if (i>=next && j>=next && sum[i][j] - sum[i-next][j] - sum[i][j-next] + sum[i-next][j-next] <= threshold) {
                    res = next++;
                }
            }
        }
        return res;        
    }
};