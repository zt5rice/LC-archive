package main

import "fmt"

func main() {
	arr := []int{1, 2, 3, 1}
	res := rob(arr)
	fmt.Println(arr)
	fmt.Println(res)
}

func rob(nums []int) int {
	n := len(nums)
	if n == 1 {
		return nums[0]
	} else if n == 2 {
		return max(nums[0], nums[1])
	}
	dp := [2]int{nums[0], max(nums[0], nums[1])}
	for i := 2; i < n; i++ {
		dp[i%2] = max(dp[(i-1)%2], dp[(i-2)%2]+nums[i])
	}
	return dp[(n-1)%2]
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
