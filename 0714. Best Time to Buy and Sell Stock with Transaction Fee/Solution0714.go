package main

import (
	"fmt"
)

func main() {
	arr := []int{1, 3, 2, 8, 4, 9}
	fee := 2
	res := maxProfit(arr, fee)
	fmt.Println(res)
}

func maxProfit(prices []int, fee int) int {
	buy := -prices[0]
	sell := 0
	for i := 1; i < len(prices); i++ {
		buy = max(buy, sell-prices[i])
		sell = max(sell, buy+prices[i]-fee)
	}
	return sell
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
