from typing import Counter, List


class Solution2244:
    def minimumRounds(self, tasks: List[int]) -> int:
        freq = Counter(tasks).values()
        return -1 if 1 in freq else sum((i+2)//3 for i in freq)

tasks = [2,2,3,3,2,4,4,4,4,4]
sol = Solution2244()
res = sol.minimumRounds(tasks)
print(res)