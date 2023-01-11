from typing import List


class Solution2364:
    def countBadPairs(self, nums: List[int]) -> int:
        count_map = {}
        n, res = len(nums), 0
        for i in range(n):
            dif = nums[i] - i
            res += count_map.get(dif, 0)
            count_map[dif] = count_map.get(dif, 0) + 1
        return n * (n - 1) // 2 - res
        