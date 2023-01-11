from typing import List


class Solution2401:
    def longestNiceSubarray(self, nums: List[int]) -> int:
        left = mask = maxLen = 0
        for right, cur in enumerate(nums):
            while (mask & nums[right]) != 0:
                mask ^= nums[left]
                left += 1
            mask |= nums[right]
            maxLen = max(maxLen, right - left + 1)
        return maxLen

# https://leetcode.cn/problems/longest-nice-subarray/solution/bao-li-mei-ju-pythonjavacgo-by-endlessch-z6t6/