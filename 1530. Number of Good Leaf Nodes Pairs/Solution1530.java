/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class Solution1530 {
    int result = 0;
    public int countPairs(TreeNode root, int distance) {
        dfs(root,distance);
        return result;
    }
    
    int[] dfs(TreeNode root,int distance){
        if(root == null)
            return new int[distance+1];
        if(root.left == null && root.right == null){
            int res[] = new int[distance+1];
            res[1]++;
            return res;
        }
        int[] left = dfs(root.left,distance); // from leaf node to cur node distance i,  left[i] how many? 
        int[] right = dfs(root.right,distance);
        for(int l=1;l<left.length;l++){
            for(int r = distance-1;r>=0;r--){
                if(l+r <=distance)
                result += left[l]*right[r];
            }
        }
        int res[] = new int[distance+1];
        //shift by 1
        for(int i=res.length-2;i>=1;i--){
            res[i+1] = left[i]+right[i];
        }
        
        return res;
    }
}

/*

1. from parent, get what?
2. from children, get what?
3. what cur node will do, to give back to parent?

node a, node b
1. root == a || b, return 0;
2. distance from children _ left = 1, right = 1;
total 1+1 = 2

3. pairs? distance <= 3   
int[] arr  - i distance from leaf node to cur, arr[i] = how many
                      i
           0       0  1
4: return [1]  -> [0  1] return to node 2
5:        [1]  -> [0  1]
                      j
                      
                   i + j <= distance,  left[i] * right[j]

1. int[] left = dfs(root.left)
          right
    i, left; j, right;
    i + j <= distance, count += left[i] * right[j];
2.  left i,  right j 
parent   i+1       j+1
    distance [    ]
             
2:  left: [0 1], right [0 1]
          [0 0 2]
          
          [0 1 2 3 ... d]
           n n n n ......
           
tc: o(n), sc: o(height * distance)
*/