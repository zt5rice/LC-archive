class Solution:
    def evaluateTree(self, root: Optional[TreeNode]) -> bool:
        if not root.left and not root.right:
            return root.val # in python, 0s and 1s can be truthy
        
        # otherwise, it either has to be a 2 or 3
        # in which, if it's 2, this is OR, so we OR the results of left and right subtrees
        if root.val == 2:
            return self.evaluateTree(root.left) or self.evaluateTree(root.right)
        else:
            return self.evaluateTree(root.left) and self.evaluateTree(root.right)   