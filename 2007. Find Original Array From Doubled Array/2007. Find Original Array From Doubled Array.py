from collections import Counter
from typing import List
"""
This solution is the same as Leetcode 954 Array of Doubled Pairs. 
The only difference is that we are not giving true or false but append the key to result list instead.
TC: O(N)
SC: O(N)
"""
class Solution:
    def findOriginalArray(self, changed: List[int]) -> List[int]:
        array_dict = Counter(changed)
        result = []
        for key in list(array_dict.keys()):
            if not array_dict[key]:
                continue
            if not self.remove_pairs(array_dict, key, result):
                return []
        return result
    
    def remove_pairs(self, array_dict, key, result):
        if key == 0:
            if array_dict[key] % 2 == 1:
                return False
            result += [key] * (array_dict[key] // 2)
            return True
        while key % 2 != 1 and key//2 in array_dict and array_dict[key//2] > 0:
            key //= 2
        while 2 * key in array_dict and array_dict[2*key] >= array_dict[key]:
            array_dict[2*key] -= array_dict[key]
            result += [key] * array_dict[key]
            array_dict[key] = 0
            key *= 2
        if array_dict[key] != 0:
            return False
        return True
#method2
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