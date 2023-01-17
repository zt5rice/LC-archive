class Solution0871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int steps = 0, curLoc = 0, idx = 0;
        PriorityQueue<Integer> maxheap = new PriorityQueue<>();
        maxheap.offer(-startFuel);
        while (!maxheap.isEmpty()) {
            curLoc -= maxheap.poll();
            if (curLoc >= target) {
                return steps;
            }
            while (idx < stations.length && curLoc >= stations[idx][0]) {
                maxheap.offer(-stations[idx++][1]);
            }
            steps++;
        }
        return -1;
    }
}

class Solution0871_DP { // 01
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        int[] dp = new int[n+1]; // [0,i) jumps, farthest distance
        dp[0] = startFuel;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j > 0; j--) {   
                if (dp[j-1] >= stations[i-1][0]) {
                    dp[j] = Math.max(dp[j], dp[j-1]+ stations[i-1][1]);
                }
            }
        }
        for (int j = 0; j < n+1; j++) {
            if (dp[j] >= target) {
                return j;
            }
        }
        return -1;        
    }
    
    public int minRefuelStops0(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        int[][] dp = new int[n+1][n+1]; // [0,i) stations, stops j times, ->farthest,  i>=j
        for (int i = 0; i <= n; i++) {
            dp[i][0] = startFuel;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // non-stop
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                // stops
                if (dp[i-1][j-1] >= stations[i-1][0]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + stations[i-1][1]);
                }
            }
        }
        for (int j = 0; j < n+1; j++) {
            if (dp[n][j] >= target) {
                return j;
            }
        }
        return -1;
    }
}