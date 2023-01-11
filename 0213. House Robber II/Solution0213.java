class Solution0213 { // rolling dp array method is harder 
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return rob(nums, 0, 0);
        }       
        return Math.max(rob(nums, 0, n-2), rob(nums, 1, n-1));
    }
    public int rob(int[] nums, int st, int ed) {
        int n = nums.length;
        if (st == ed) {
            return nums[st];
        }
        if (ed - st == 1) {
            return Math.max(nums[ed], nums[st]);
        }
        int[] dp = new int[3]; // 0-st, 
        dp[0] = nums[st]; dp[1] = Math.max(nums[st], nums[st+1]); // !!!
        for (int i = 2; i < ed-st+1; i++) { // !!!
            dp[i%3] = Math.max(dp[(i-2)%3]+nums[st+i], dp[(i-1)%3]);
        }
        return dp[(ed-st+1-1)%3]; // !!!
    }
}

class Solution0213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return rob(nums,0,0);  
        return Math.max(rob(nums,0,n-2), rob(nums,1,n-1));
    }
    
    private int rob(int[] nums, int s, int e) {
        if (s == e) {
            return nums[s];
        }
        if (s == e - 1) {
            return Math.max(nums[s], nums[e]);
        }
        int p1 = Math.max(nums[s], nums[s+1]), p2 = nums[s];
        int cur = p1;
        for (int i = s+2; i <= e; i++) {
            cur = Math.max(p1, p2 + nums[i]);
            p2 = p1;
            p1 = cur;
        }
        return p1;
    }
}