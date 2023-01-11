package main

import (
	"fmt"
)

func main() {
	tasks := []int{2, 2, 3, 3, 2, 4, 4, 4, 4, 4}
	res := minimumRounds(tasks)
	fmt.Println(" input:", tasks)
	fmt.Println("output:", res)
}

func minimumRounds(tasks []int) int {
	res, count := 0, make(map[int]int)
	for _, t := range tasks {
		count[t]++
	}
	for _, v := range count {
		if v == 1 {
			return -1
		}
		res += (v + 2) / 3
	}
	return res
}
