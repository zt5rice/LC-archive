func subarraysDivByK(nums []int, k int) int {
	curSum, curRem, count := 0, 0, 0
	rem := map[int]int{0: 1}         // !!! init zero array as map
	for i := 0; i < len(nums); i++ { // for _,num:=range nums{
		curSum += nums[i]
		curRem = curSum % k
		if curRem < 0 {
			curRem += k
		}
		count += rem[curRem]
		rem[curRem] += 1
	}
	return count
}