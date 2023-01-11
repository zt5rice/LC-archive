class Solution0132:
    def minCut(self, s: str) -> int:
        dp = [i for i in range(len(s))]
        for mid in range(len(s)):
            self.helper(s, mid-1, mid, dp)            
            self.helper(s, mid, mid, dp)
        return dp[len(s)-1]
    
    def helper(self, s:str, left: int, right: int, dp: List[int]) -> None:
        while left >= 0 and right < len(s) and s[left] == s[right]:
            range_min_cut = 0 if left == 0 else (dp[left-1] + 1)
            dp[right] = min(dp[right], range_min_cut)
            left-=1
            right+=1