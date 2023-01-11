from collections import Counter
from typing import List


class Solution2007:
    def findOriginalArray(self, changed: List[int]) -> List[int]:
        if len(changed) % 2 != 0:
            return []
        original = []
        max_changed = max(changed)
        freq = Counter(changed)
            
        for i in range(max_changed+1):
            if i == 0:
                if freq[i] % 2 > 0:
                    return []
                original += [0] * (freq[i] // 2)
            elif freq[i] > 0: 
                original += [i] * freq[i]
                if freq[2*i] >= freq[i]:
                    freq[2*i]-=freq[i]
                else:
                    return []
        return original