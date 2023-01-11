from typing import List


class Solution0944:
    def minDeletionSize(self, strs: List[str]) -> int:
        row, col = len(strs), len(strs[0])
        res = 0
        for c in range(col):
            for r in range(1,row):
                if ord(strs[r][c]) < ord(strs[r-1][c]):
                    res += 1
                    break
        return res

sol = Solution0944()
strs = ["cba","daf","ghi"]
res = sol.minDeletionSize(strs)
print('input :', strs)
print('output:', res)