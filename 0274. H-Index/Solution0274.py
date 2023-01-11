class Solution:
    def hIndex0(self, citations: List[int]) -> int:
        citations.sort()
        res, idx = 0, len(citations)-1
        while idx >= 0 and citations[idx] > res:
            res+=1
            idx-=1
        return res  

    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        count = [0]* (n+1)
        for c in citations:
            count[min(c,n)]+=1
                
        tot = 0
        for i in range(n,-1,-1):
            tot += count[i]
            if tot >= i: #definition
                return i
        return 0