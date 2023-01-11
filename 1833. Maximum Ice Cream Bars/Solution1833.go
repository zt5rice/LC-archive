import "sort"

func maxIceCream(costs []int, coins int) int {
	sort.Ints(costs)
	resp := 0
	for _, price := range costs {
		if coins >= price {
			coins -= price
			resp++
		}
	}
	return resp
}