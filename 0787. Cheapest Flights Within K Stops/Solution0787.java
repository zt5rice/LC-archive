class Solution0787 { // Bellman-ford
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dp = new int[n];
        int INF = Integer.MAX_VALUE / 2;
        Arrays.fill(dp, INF);
        dp[src] = 0;
        for (int i = 0; i < k + 1; i++) {
            int[] prev = dp.clone();
            for (int[] flight : flights) {
                dp[flight[1]] = Math.min(dp[flight[1]], prev[flight[0]] + flight[2]);
            }
        }
        return dp[dst] == INF ? -1 : dp[dst];
    }
}