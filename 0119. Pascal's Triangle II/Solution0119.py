from typing import List


class Solution0119:
    def getRow(self, rowIndex: int) -> List[int]:
        res = [1]
        for i in range(rowIndex):
            res.append(res[-1] * (rowIndex - i) // (i+1))
        return res