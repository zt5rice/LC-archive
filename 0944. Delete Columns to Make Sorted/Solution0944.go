package main

import (
	"fmt"
)

func main() {
	strs := []string{"cba", "daf", "ghi"}
	res := minDeletionSize(strs)
	fmt.Println(res)
}

func minDeletionSize(strs []string) int {
	row, col := len(strs), len(strs[0])
	res := 0
	for c := 0; c < col; c++ {
		for r := 1; r < row; r++ {
			if strs[r][c] < strs[r-1][c] {
				res++
				break
			}
		}
	}
	return res
}
