class Solution0312 { // 13
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = arr[n+1] = 1;
        for (int i = 1; i < n+1; i++) {
            arr[i] = nums[i-1];
        }
        int[][] dp = new int[n+2][n+2];
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+2; j <= n+1; j++) {
                for (int k = i+1; k < j; k++) {
                    int sum = arr[i] * arr[j] * arr[k];
                    sum += (dp[i][k] + dp[k][j]);
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }
        return dp[0][n+1];
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode.cn/problems/burst-balloons/solution/chuo-qi-qiu-by-leetcode-solution/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。