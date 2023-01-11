/*
TC: O(n)
SC: O(n) for the map, logn for the recursion tree

*/
class Solution0105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>(); // value to index for inorder traversal
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        int[] index = new int[1];
        return helper(preorder, inMap, 0, inorder.length - 1, 0, preorder.length - 1);
    }
    private TreeNode helper(int[] preorder, Map<Integer, Integer> inMap, int inStart, int inEnd, int preStart, int preEnd) {
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[preStart]);
        int mid = inMap.get(preorder[preStart]);
      
        node.left = helper(preorder, inMap, inStart, mid - 1, preStart + 1, preStart + mid - inStart);
       
        node.right = helper(preorder, inMap, mid + 1, inEnd, preStart + 1 + mid - inStart, preEnd);
        
        return node;
    }
}

class Solution0105_2 {
    int preorderIdx;
    Map<Integer, Integer> inMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       this.inMap = new HashMap<>();
       for (int i = 0; i < inorder.length; i++) {
           this.inMap.put(inorder[i], i);
       }
       this.preorderIdx = 0;
       return helper(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int left, int right) {
        if (left>right) return null;
        int rootVal = preorder[this.preorderIdx++];
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, left, inMap.get(rootVal)-1);
        root.right = helper(preorder, inMap.get(rootVal)+1, right);
        return root;
    }
}