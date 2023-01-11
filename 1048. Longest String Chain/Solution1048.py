from typing import List


class Solution1048:
    def longestStrChain(self, words: List[str]) -> int:
        length_map = {}
        for word in sorted(words, key=len):
            length_map[word] = max(length_map.get(word[:i]+word[i+1:],0)+1 for i in range(len(word)))
        return max(length_map.values())

# https://leetcode.com/problems/longest-string-chain/discuss/294890/JavaC%2B%2BPython-DP-Solution