class Solution2436 {
    public int minimumSplits(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int gcd = nums[0];
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (getGCD(gcd, nums[i]) == 1) {
                res++;
                gcd = nums[i];
            } else {
                gcd = getGCD(gcd, nums[i]);
            }
        }
        return res;
    }
    public int getGCD(int a, int b) {
        return b == 0 ? a : getGCD(b, a%b);
    }
}