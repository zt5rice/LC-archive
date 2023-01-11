class Solution1996:
    def numberOfWeakCharacters(self, properties: List[List[int]]) -> int:
        properties.sort(key=lambda p:(-p[0], p[1]))
        count,attMax = 0, 0
        for _, d in properties:
            if d < attMax:
                count +=1
            else:
                attMax = max(attMax, d)
        return count