class Solution0926:
    def minFlipsMonoIncr(self, s: str) -> int:
        res, ones = 0, 0
        for i in range(len(s)):
            if s[i] == '1':
                ones += 1
            else: # '0'
                res = min(ones, res + 1)
        return res