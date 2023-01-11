class Solution2256 { // 44
    public int minimumAverageDifference(int[] nums) {
        long minDiff = (long) Integer.MAX_VALUE;
        int resIdx = -1;
        int n = nums.length;
        long[] sum = new long[n]; sum[0] = (long)nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            long curDiff = calcDiff(sum, i);
            if (curDiff < minDiff) {
                minDiff = curDiff;
                resIdx = i;
                if (minDiff == 0) break;
            }
        }
        return resIdx;
    }
    
    private long calcDiff(long[] sum, int i) {
        int n = sum.length;
        long left = sum[i]/(i+1);
        
        long right = (n-1-i) == 0 ? 0L : (sum[n-1] - sum[i]) / (n-1-i);
        return Math.abs(right - left);
    }
}