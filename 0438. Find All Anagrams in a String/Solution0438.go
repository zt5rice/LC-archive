func findAnagrams(s string, p string) []int {
	var res []int
	var sarr, parr [26]int

	for i := 0; i < len(p); i++ {
		parr[p[i]-'a']++
	}
	for j := 0; j < len(s); j++ {
		if j >= len(p) {
			sarr[s[j-len(p)]-'a']--
		}
		sarr[s[j]-'a']++
		if j >= len(p)-1 {
			if sarr == parr {
				res = append(res, j-len(p)+1)
			}
		}
	}
	return res
}