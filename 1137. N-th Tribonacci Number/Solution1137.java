class Solution1137 {
    public int tribonacci(int n) {
        int[] dp = new int[]{0, 1, 1};
        int cursum = 2;
        for (int i = 3; i <= n; i++) {
            int prev = dp[(i-3)%3];
            dp[i%3] = cursum;
            cursum = 2*cursum-prev;
        }
        return dp[n%3];
    }
    // public int tribonacci(int n) {
    //     Deque<Integer> prev = new ArrayDeque<>();
    //     int sum = 0;
    //     if (n >= 0) {
    //         sum += 0;
    //         prev.offerLast(0);
    //         if (n == 0) return 0;
    //     } 
    //     if (n >= 1) {
    //         sum += 1;
    //         prev.offerLast(1);
    //         if (n == 1) return 1;
    //     }
    //     if (n >= 2) {
    //         sum += 1;
    //         prev.offerLast(1);
    //         if (n == 2) return 1;            
    //     }
    //     for (int i = 3; i < n; i++) {
    //         prev.offerLast(sum);
    //         int tmp = prev.pollFirst(); 
    //         sum -=  tmp;
    //         sum += prev.peekLast();  
    //     }
    //     return sum;
    // }
}