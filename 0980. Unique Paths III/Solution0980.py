from typing import List


class Solution0980:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        startR, startC = -1, -1
        r, c = len(grid), len(grid[0])
        count0 = 1
        for i in range(r):
            for j in range(c):
                if grid[i][j] == 1:
                    startR, startC = i, j
                if grid[i][j] == 0:
                    count0 += 1
        return self.dfs(startR, startC, count0, grid)
    
    def dfs(self, startR: int, startC: int, count0: int, grid: List[List[int]]) -> int:
        if startR < 0 or startR >= len(grid) or startC < 0 or startC >= len(grid[0]) or grid[startR][startC] == -1:
            return 0
        if grid[startR][startC] == 2:
            return 1 if count0 == 0 else 0
        grid[startR][startC] = -1 
        res = 0
        res += self.dfs(startR-1, startC, count0 - 1, grid)
        res += self.dfs(startR+1, startC, count0 - 1, grid)
        res += self.dfs(startR, startC-1, count0 - 1, grid)
        res += self.dfs(startR, startC+1, count0 - 1, grid)
        grid[startR][startC] = 0
        return res