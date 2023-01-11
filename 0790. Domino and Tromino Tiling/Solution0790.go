package main

import (
	"fmt"
)

func main() {
	n := 3
	fmt.Println(n)
	res := numTilings(n)
	fmt.Println(res)
}

func numTilings(n int) int {
	dp := [4]int{1, 0, 0, 1}
	MOD := 1000000007
	for i := 2; i <= n; i++ {
		tmp := [4]int{0: 4}
		tmp[0] = dp[3] % MOD
		tmp[1] = (dp[0] + dp[2]) % MOD
		tmp[2] = (dp[0] + dp[1]) % MOD
		tmp[3] = (dp[0] + dp[1] + dp[2] + dp[3]) % MOD
		dp = tmp
	}
	return dp[3] % MOD
}
