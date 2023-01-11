public class Solution2400 { // buttom-up dp
    public int numberOfWays(int startPos, int endPos, int k) {
        if ((Math.abs(endPos - startPos) + k)%2 != 0 || Math.abs(endPos - startPos) > k) {
            return 0;
        }
        int offset = startPos - k, n = startPos + k - offset+1;
        // System.out.println(n);
        int MOD = (int) 1e9 + 7;
        long[][] dp = new long[k+1][n+1]; // offset k,  pos,#steps
        dp[0][startPos-offset] = 1L;
        // System.out.println(Arrays.toString(dp[0]));
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = (j+1<=n ? dp[i-1][j+1] : 0L) + ((j >= 1) ? dp[i-1][j-1] : 0L);
                dp[i][j] %= MOD; 
            }
            // System.out.println(Arrays.toString(dp[i]));
        }
        return (int) (dp[k][endPos-offset] % MOD);
    }    
}
