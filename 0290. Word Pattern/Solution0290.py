class Solution0290:
    def wordPattern(self, pattern: str, s: str) -> bool:
        wordlist = s.split(' ')
        # print(wordlist)
        idxmap = {}
        if len(pattern) != len(wordlist):
            return False
        for i in range(len(pattern)):
            if 'p:'+pattern[i] not in idxmap:
                idxmap['p:'+pattern[i]] = i
            if 'l:'+wordlist[i] not in idxmap:
                idxmap['l:'+wordlist[i]] = i
            if idxmap['p:'+pattern[i]] != idxmap['l:'+wordlist[i]]:
                return False
        return True
