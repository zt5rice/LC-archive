class Solution0105:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        def helper(left, right):
            nonlocal preorder_index
            if left > right: return None
            root_value = preorder[preorder_index]
            preorder_index += 1
            root = TreeNode(root_value)
            root.left = helper(left, inMap[root_value]-1)
            root.right = helper(inMap[root_value]+1, right)
            return root
        
        preorder_index = 0
        inMap = {}
        for index, value in enumerate(inorder):
            inMap[value] = index
        return helper(0, len(inorder)-1)