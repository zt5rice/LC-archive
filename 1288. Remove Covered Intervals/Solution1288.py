from typing import List


class Solution1288:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        n = len(intervals)
        intervals.sort(key=lambda u:(u[0], -u[1]))
        count, end = 1, intervals[0][1]
        for i in range(1,n):
            if intervals[i][1] > end:
                count += 1
                end = intervals[i][1]
        return count
    