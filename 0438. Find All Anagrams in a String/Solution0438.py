class Solution0438:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        s_arr, p_arr = self.convArr(''), self.convArr(p)
        res = []
        for i in range(len(s)):
            if i >= len(p):
                s_arr[ord(s[i-len(p)])-ord('a')] -= 1
            s_arr[ord(s[i])-ord('a')] += 1
            if i >= len(p) - 1:
                if self.arr_equal(s_arr, p_arr):
                    res.append(i+1-len(p))
        return res
        
    def arr_equal(self, s_arr, p_arr) -> bool:
        for i in range(26):
            if s_arr[i] != p_arr[i]:
                return False
        return True

    def convArr(self, s) -> List[int]:
        res = [0 for _ in range(26)]
        for i in range(len(s)):
            res[ord(s[i]) - ord('a')] += 1
        return res