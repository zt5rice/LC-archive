from typing import List


class Solution0329:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        m, n = len(matrix), len(matrix[0])
        dp = [[1 for i in range(n)] for i in range(m)]
        longest = 1
        for i in range(m):
            for j in range(n):
                longest = max(longest, self.dfs(i, j, matrix, dp))
        return longest

        
    def dfs(self, r: int, c: int, matrix: List[List[int]], dp: List[List[int]]) -> int: 
        m, n = len(matrix), len(matrix[0])
        if dp[r][c] != 1:
            return dp[r][c]
        directions = [(1,0), (-1,0), (0,1), (0,-1)]
        for dr, dc in directions:
            nextr = r + dr
            nextc = c + dc
            if nextr < 0 or nextr >= m or nextc < 0 or nextc >= n or matrix[nextr][nextc] <= matrix[r][c]:
                continue
            dp[r][c] = max(dp[r][c], self.dfs(nextr, nextc, matrix, dp)+1)

        return dp[r][c]
        
        