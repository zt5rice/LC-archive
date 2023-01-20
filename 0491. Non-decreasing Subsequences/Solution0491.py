class Solution0491:
    def findSubsequences(self, nums: List[int]) -> List[List[int]]:
        def dfs(i, prev, curr):
            if len(curr) >= 2:
                ans.add(curr[:])
            if i >= len(nums):
                return
            for j in range(i, len(nums)):
                if nums[j] >= prev:
                    dfs(j+1, nums[j], curr+(nums[j],))
        ans = set()
        dfs(0, -float('inf'), ())
        return ans