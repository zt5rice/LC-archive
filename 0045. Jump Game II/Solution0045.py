class Solution0045:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        cur, farthest, steps = 0, 0, 0
        for i in range(n-1):
            if i > cur:
                return -1
            farthest = max(farthest, i + nums[i])
            if farthest >= n-1:
                return steps + 1
            if i == cur:
                cur = farthest
                steps += 1
        return steps