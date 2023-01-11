class Solution1457:
    def __init__(self):
        self.count = 0
        
    def pseudoPalindromicPaths (self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        self.helper(root, 0)
        return self.count
    
    def helper(self, root: TreeNode, num: int) -> None:
        curr = num ^ (1 << root.val);
        if (not root.left) and (not root.right):
            if curr == 0 or (curr & (curr - 1)) == 0:
                self.count += 1
        if root.left:
            self.helper(root.left, curr)
        if root.right:
            self.helper(root.right, curr) 