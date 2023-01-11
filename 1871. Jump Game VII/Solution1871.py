class Solution1871:
    def canReach(self, s: str, minJump: int, maxJump: int) -> bool:
        n = len(s)
        cnt = 1
        dp = [False for i in range(n)]
        dp[0] = True
        for i in range(minJump, n):
            if s[i] == '0' and cnt > 0:
                dp[i] = True
            if i >= maxJump and dp[i-maxJump]:
                cnt -= 1
            if dp[i-minJump+1]:
                cnt += 1
        return dp[n-1]