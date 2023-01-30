import "math"

func findCheapestPrice(n int, flights [][]int, src int, dst int, k int) int {
	prev := []int{}
	now := make([]int, n)
	for j := range now {
		now[j] = math.MaxInt32
	}
	now[src] = 0
	for i := 0; i < k+1; i++ {
		prev = now
		now = append([]int{}, prev...)
		for _, flight := range flights {
			now[flight[1]] = min(now[flight[1]], prev[flight[0]]+flight[2])
		}
	}
	if now[dst] == math.MaxInt32 {
		return -1
	}
	return now[dst]
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}