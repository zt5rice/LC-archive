import "strconv"

func maxPoints(points [][]int) int {
	res, n := 1, len(points)
	for i := 0; i < n; i++ {
		countMap := make(map[string]int)
		x1, y1, iMax := points[i][0], points[i][1], 1
		for j := i + 1; j < n; j++ {
			x2, y2 := points[j][0], points[j][1]
			dx, dy := (x2 - x1), (y2 - y1)
			d := gcd(dx, dy)
			key := strconv.Itoa(dx/d) + "_" + strconv.Itoa(dy/d)
			count, found := countMap[key]
			if !found {
				count = 1
			}
			count += 1
			countMap[key] = count
			iMax = max(count, iMax)
		}
		res = max(res, iMax)
	}
	return res
}

func gcd(x, y int) int {
	if y != 0 {
		return gcd(y, x%y)
	}
	return x
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}