func longestCommonSubsequence(text1 string, text2 string) int {
	var n1, n2 int = len(text1), len(text2)
	var dp [][]int = make([][]int, n1+1)
	for i := 0; i < n1+1; i++ {
		dp[i] = make([]int, n2+1)
	}
	for i := 0; i < n1; i++ {
		for j := 0; j < n2; j++ {
			if text1[i] == text2[j] {
				dp[i+1][j+1] = dp[i][j] + 1
			} else {
				if dp[i+1][j] > dp[i][j+1] {
					dp[i+1][j+1] = dp[i+1][j]
				} else {
					dp[i+1][j+1] = dp[i][j+1]
				}

			}
		}
	}
	return dp[n1][n2]
}