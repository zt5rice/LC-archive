func jump(nums []int) int {
	steps, cur, farthest, n := 0, 0, 0, len(nums)
	for i := 0; i < n-1; i++ {
		if i+nums[i] > farthest {
			farthest = i + nums[i]
		}
		if farthest >= n-1 {
			return steps + 1
		}
		if i == cur {
			cur, steps = farthest, steps+1
		}
	}
	return steps
}

// https://leetcode.com/problems/jump-game-ii/solutions/1193341/o-n-golang-solution-beats-100/?