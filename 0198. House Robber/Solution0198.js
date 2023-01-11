
var rob = function(nums) {
    n = nums.length;
    if (n == 1) {
        return nums[0];
    }
    if (n == 2) {
        return Math.max(nums[0], nums[1]);
    }
    dp = [nums[0], Math.max(nums[0], nums[1])];
    for (let i = 2; i < n; i++) {
        dp[i % 2] = Math.max(dp[(i-1)%2], dp[(i)%2] + nums[i]);
    }
    return dp[(n-1)%2];
};


