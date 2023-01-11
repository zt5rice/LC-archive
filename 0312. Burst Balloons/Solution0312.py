from typing import List


class Solution0312:
    def maxCoins(self, nums: List[int]) -> int:
        n = len(nums)
        val = [0 for i in range(n+2)]
        for i in range(1, n+1):
            val[i] = nums[i-1]
        val[0] = val[n+1] = 1
        
        dp = [[0 for i in range(n+2)] for i in range(n+2)]
        
        for i in range(n-1,-1,-1):
            for j in range(i+2, n+2):
                for k in range(i+1,j):
                    tmp = val[i] * val[k] * val[j]
                    tmp += dp[i][k] + dp[k][j]
                    dp[i][j] = max(dp[i][j], tmp)
                    
        return dp[0][n+1]