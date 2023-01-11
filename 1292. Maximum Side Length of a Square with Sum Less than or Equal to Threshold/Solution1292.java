class Solution1292 {
    public int maxSideLength(int[][] mat, int threshold) {
        int r = mat.length, c = mat[0].length;
        int[][] sum = new int[r+1][c+1];
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
}
// https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/discuss/451871/Java-sum%2Bbinary-O(m*n*log(min(mn)))-or-sum%2Bsliding-window-O(m*n)