class Solution0539:
    def findMinDifference(self, timePoints: List[str]) -> int:
        t = sorted(int(i[:2])*60+int(i[-2:]) for i in timePoints)
        t.append(t[0]+24*60)
        return min(b-a for a, b in zip(t, t[1:]))

    def findMinDifference0(self, timePoints: List[str]) -> int:
        def convTime(timePoint: str) -> int:
            hr, mn = int(timePoint[:2]), int(timePoint[3:])
            return hr*60+mn 
            
        n,res = len(timePoints), 24*60    
        times = []
        for timePoint in timePoints:
            times.append(convTime(timePoint))
        times.sort()
        for i in range(1,n):
            res = min(res, times[i]-times[i-1])
        res = min(res, times[0]+24*60-times[n-1])
        return res