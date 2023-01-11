var longestCommonSubsequence = function(text1, text2) {
    let n1 = text1.length;
    let n2 = text2.length;
    let dp = new Array(n1+1).fill(null).map(()=>new Array(n2+1).fill(0));
    for (let i = 0; i < n1; i++) {
        for (let j = 0; j < n2; j++) {
            if (text1[i] == text2[j]) {
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + 1);
            } else {
                dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
            }
        }
    }
    return dp[n1][n2];
};