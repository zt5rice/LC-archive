class Solution0606:
    def tree2str(self, root: Optional[TreeNode]) -> str:
        if not root:
            return ""
        res = str(root.val)
        left = self.tree2str(root.left)
        right = self.tree2str(root.right)
        if left or right:
            res += '('
            res += left
            res += ')'
        if right:
            res += '('
            res += right
            res += ')'
        return res