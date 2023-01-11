class Solution:
    # lee215 method
    def findReplaceString(self, s: str, indices: List[int], sources: List[str], targets: List[str]) -> str:
        for i, src, tgt in sorted(zip(indices, sources, targets),reverse=True):
            s = s[:i] + tgt + s[i+len(src):] if s[i:i+len(src)]==src else s
        return s
    