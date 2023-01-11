public class Solution1105 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n+1];
        int INF = Integer.MAX_VALUE / 2;
        Arrays.fill(dp, INF);
        dp[0] = 0;
        dp[1] = books[0][1];
        for (int i = 2; i <= books.length; i++) {
            int curWid = 0;
            int curHeight = 0;
            for (int j = i-1; j >= 0; j--) {
                curWid += books[j][0];
                curHeight = Math.max(curHeight, books[j][1]);
                if (curWid > shelfWidth) break;
                dp[i] = Math.min(dp[i], dp[j] + curHeight);
            }
        }
        return dp[n];
    }    
}
