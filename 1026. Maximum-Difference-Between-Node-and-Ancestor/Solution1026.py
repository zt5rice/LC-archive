class Solution1026:
    def maxAncestorDiff(self, root: Optional[TreeNode]) -> int:
        return self.helper(root, root.val, root.val)
    
    def helper(self, root: TreeNode, minVal: int, maxVal: int) -> int:
        if not root:
            return maxVal - minVal
        maxVal = max(maxVal, root.val)
        minVal = min(minVal, root.val)
        left = self.helper(root.left, minVal, maxVal)
        right = self.helper(root.right, minVal, maxVal)
        return max(left, right)