class Solution2172 {
    public int maximumANDSum(int[] nums, int numSlots) {
        int n = nums.length, M = 1;
        for (int i = 0; i < numSlots; i++) M *= 3;
        int[][] dp = new int[n+1][M];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < M; j++) {
                int t = j, w = 1; 
                for (int k = 1; k <= numSlots; k++) {
                    if (t % 3 != 0) { // still available position
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w] + (k&nums[i-1]));
                    }
                    t /= 3;
                    w *= 3;
                }
            }
        }
        return dp[n][M-1];
    }
// 作者：zhao, adapt from newhar
// 链接：https://leetcode.cn/problems/maximum-and-sum-of-array/solution/san-jin-zhi-zhuang-tai-ya-suo-by-newhar-t3fe/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}