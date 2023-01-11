# Definition for a binary tree node.
from typing import List


class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
         
class Solution1339:
    def maxProduct(self, root: Optional[TreeNode]) -> int:
        sumList = []
        totSum = self.helper(root, sumList)
        res = 0
        for curSum in sumList:
            res = max(res, (curSum * (totSum - curSum)) )
        return res%(10**9+7)
    
    def helper(self, root:TreeNode, sumList: List) -> int:
        if not root:
            return 0
        left = self.helper(root.left, sumList)
        right = self.helper(root.right, sumList)
        curSum = (left + right + root.val) 
        sumList.append(curSum) 
        return curSum % (10**9+7)