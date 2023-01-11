# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution0235:
    def lowestCommonAncestor0(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if p.val <= root.val <= q.val or q.val <= root.val <= p.val:
            return root
        if p.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        return self.lowestCommonAncestor(root.right, p, q)

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        cur = root
        minVal = min(p.val, q.val)        
        maxVal = max(p.val, q.val)
        while cur:
            if cur.val < minVal:
                cur = cur.right
            elif cur.val > maxVal:
                cur = cur.left
            else:
                return cur
        return None