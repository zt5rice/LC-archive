import collections
from typing import List


class Solution0948:
    def bagOfTokensScore(self, tokens: List[int], power: int) -> int:
        res = cur = 0
        dq = collections.deque(sorted(tokens))
        while dq and (power >= dq[0] or cur > 0):
            if power >= dq[0]:
                cur+=1
                power-=dq.popleft()
                res = max(res, cur)
            elif cur > 0:
                cur-=1
                power+=dq.pop()
        return res