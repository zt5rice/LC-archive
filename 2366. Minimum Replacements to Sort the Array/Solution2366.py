from typing import List


class Solution2366:
    def minimumReplacement(self, nums: List[int]) -> int:
        res, n, prev, k = 0, len(nums), 1000000000, 0
        for i in range(n-1,-1,-1):
            k = (nums[i] - 1 + prev) // prev
            prev = nums[i] // k
            res += k - 1
        return res
# ref https://leetcode.com/problems/minimum-replacements-to-sort-the-array/discuss/2388265/JavaC%2B%2BPython-One-Reverse-Pass