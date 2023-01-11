class Solution2444:
    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        res, ibad, imax, imin = 0, -1, -1, -1
        for i, num in enumerate(nums):
            if num < minK or num > maxK:
                ibad = i
            if num == minK:
                imin = i
            if num == maxK:
                imax = i
            res += max(0, min(imin, imax) - ibad)
        return res