/**
 * @param {number} n
 * @return {number}
 */
var tribonacci = function(n) {
    let dp = [0, 1, 1];
    let cursum = 2;
    for (let i = 3; i <= n; i++) {
        let prev = dp[(i-3)%3];
        dp[i%3] = cursum;
        cursum = 2*cursum-prev;
    }
    return dp[n%3];    
};