public class Solution1339 {
    //  tc/sc: O(n)
    private static final int MOD = 1000000007;
    public int maxProduct(TreeNode root) {
        List<Integer> sumVals = new ArrayList<>();
        long totSum = helper(root, sumVals);
        
        long maxProd = Integer.MIN_VALUE;
        for (int sum : sumVals) {
            maxProd = Math.max(maxProd, sum * (totSum - sum));
        }
        return (int) (maxProd % MOD);
    }
    
    private int helper(TreeNode root, List<Integer> sumVals) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, sumVals);
        int right = helper(root.right, sumVals);
        int curSum = left + right + root.val;
        sumVals.add(curSum);
        return curSum % MOD;
    }
       
}
