import bisect
import random
from typing import List

class Solution0528:

    def __init__(self, w: List[int]):
        w = list(map(lambda x: x/sum(w), w))
        for i in range(1,len(w)):
            w[i] += w[i-1]
        self.w = w 

    def pickIndex(self) -> int:
        r = random.uniform(0,1)
        return bisect.bisect_left(self.w, r)


# Your Solution object will be instantiated and called as such:
# obj = Solution(w)
# param_1 = obj.pickIndex()