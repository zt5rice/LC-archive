from typing import List


class Solution0134:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        curgas, totgas, totcost, n, cand = 0, 0, 0, len(gas), 0
        for i in range(n):
            curgas += gas[i] - cost[i]
            if curgas < 0:
                curgas = 0
                cand = i + 1
            totgas += gas[i]
            totcost += cost[i]
        if totgas < totcost:
            return -1
        return cand
                