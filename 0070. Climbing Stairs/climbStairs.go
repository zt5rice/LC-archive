func climbStairs(n int) int {
	if n < 2 {
		return n
	}
	var pp uint32 = 1
	var p uint32 = 1
	var c uint32 = 2
	for i := 2; i <= n; i++ {
		c = pp + p
		pp = p
		p = c
	}
	return int(c)

}