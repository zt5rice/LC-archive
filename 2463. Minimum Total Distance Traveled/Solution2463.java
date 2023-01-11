public class Solution2463 {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a,b)->a[0]-b[0]);
    
        Long[][][] dp = new Long[robot.size()+1][factory.length+1][101];
    
        return helper(robot, factory, dp, 0, 0, 0);
    }
    
    public long helper(List<Integer> robot, int[][] factory, Long[][][] dp, int i, int j, int k) {
        if(i==robot.size()) return 0;
        if(j==factory.length) return Long.MAX_VALUE;
        if(dp[i][j][k] != null) return dp[i][j][k];
    
        long res1 = helper(robot, factory, dp, i, j+1, 0);
        long res2 = Long.MAX_VALUE;
    
        if(factory[j][1] > k) {
            long val = helper(robot, factory, dp, i+1, j, k+1);
            if(val != Long.MAX_VALUE) {
                res2 = Math.abs(robot.get(i)-factory[j][0]) + val;
            }
        }
    
        return dp[i][j][k] = Math.min(res1, res2);
    }    
}

class Solution2463_1 {
    long[][] dp;
    List<Integer> robot;
    int[][] factory;
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        this.robot = robot;
        Arrays.sort(factory,
                   (i1, i2) -> i1[0] != i2[0] ? Integer.compare(i1[0],i2[0]) : Integer.compare(i1[1],i2[1]) 
                   );
        this.factory = factory;
        int nr = robot.size(), nf = factory.length;
        this.dp = new long[nr+1][nf+1];
        return dfs(0, 0); // ir, ifa
    }
    
    private long dfs(int ir, int ifa) {
        if (ir >= robot.size()) return 0L;
        if (ifa >= factory.length) return Long.MAX_VALUE;
        if (dp[ir][ifa] > 0) return dp[ir][ifa];
        long res = dfs(ir, ifa+1);
        long cur = 0L;
        
        for (int k = ir; k < robot.size() && k -ir + 1 <= factory[ifa][1]; k++) { // 1,2,3,... robots
            cur += Math.abs(robot.get(k) - factory[ifa][0]);
            long next = dfs(k+1, ifa+1);
            
            if (next!=Long.MAX_VALUE) {
                res = Math.min(cur + next, res);
            }
        }
        
        return dp[ir][ifa] = res;
    }
}