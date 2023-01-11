class Solution0939:
    def minAreaRect(self, points: List[List[int]]) -> int:
        minArea = float('inf')
        seen = set()
        for x1, y1 in points:
            for x2, y2 in seen:
                if (x1,y2) in seen and (x2,y1) in seen:
                    minArea = min(minArea, abs(x1-x2)*abs(y1-y2))
            seen.add((x1,y1))
        return minArea if minArea != float('inf') else 0