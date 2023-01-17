func minFlipsMonoIncr(s string) int {
	res, ones := 0, 0
	for i := 0; i < len(s); i++ {
		if s[i] == '1' {
			ones++
		} else {
			res = min(res+1, ones)
		}
	}
	return res
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}