func tribonacci(n int) int {
	dp := [3]int{0, 1, 1}
	sum := 2
	prev := 0
	for i := 3; i <= n; i++ {
		prev = dp[(i-3)%3]
		dp[i%3] = sum
		sum = sum*2 - prev
	}
	return dp[n%3]
}