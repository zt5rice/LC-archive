class Solution0205:
    def isIsomorphic(self, s: str, t: str) -> bool:
        stt = [-1] * 256        
        tts = [-1] * 256
        n = len(s)
        for i in range(n):
            if stt[ord(s[i])] == -1 and tts[ord(t[i])] == -1:
                stt[ord(s[i])] = ord(t[i])
                tts[ord(t[i])] = ord(s[i])
            elif stt[ord(s[i])] != ord(t[i]) or tts[ord(t[i])] != ord(s[i]):
                return False
        return True