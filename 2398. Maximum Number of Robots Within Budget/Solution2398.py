class Solution2398:
    def maximumRobots(self, chargeTimes: List[int], runningCosts: List[int], budget: int) -> int:
        left, right,cursum, n = 0,0,0, len(chargeTimes)
        d = deque()
        for right in range(n):
            cursum += runningCosts[right]
            while d and chargeTimes[d[-1]] <= chargeTimes[right]:
                d.pop()
            d.append(right)
            if chargeTimes[d[0]]+(right - left+1)*cursum > budget:
                if d[0] == left:
                    d.popleft()
                cursum -= runningCosts[left] 
                left += 1
        return n - left