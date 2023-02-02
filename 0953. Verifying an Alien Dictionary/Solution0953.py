class Solution0953:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        dict_map = {}
        for i in range(len(order)):
            dict_map[order[i]] = i
        for i in range(len(words)-1):
            if not self.check(dict_map, words[i], words[i+1]):
                return False
        return True
    
    def check(self, dict_map, word1, word2) -> bool:
        for i in range(min(len(word1), len(word2))):
            if word1[i] != word2[i]:
                if dict_map[word1[i]] > dict_map[word2[i]]:
                    return False
                else:
                    return True
        if len(word1) > len(word2):
            return False 
        return True