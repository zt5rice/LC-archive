/**
 * @param {number} n
 * @return {number}
 */
var numTilings = function(n) {
    let dp = new Array(4).fill(0);
    dp[0] = 1; dp[3] = 1;
    const MOD = 1000000007;
    for (let i = 2; i <= n; i++) {
        let tmp = new Array(4).fill(0);
        tmp[0] = dp[3] % MOD;
        tmp[1] = (dp[0] + dp[2]) % MOD;
        tmp[2] = (dp[0] + dp[1]) % MOD;
        tmp[3] = (dp[0] + dp[1] + dp[2] + dp[3]) % MOD;
        dp = tmp;
    }
    return dp[3] % MOD;  
};

var n = 3;
var res = numTilings(n);
console.log('Result: ' + res);