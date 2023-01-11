/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
 var maxAncestorDiff = function(root) {
    return helper(root, root.val, root.val);
    function helper(root, minVal, maxVal) {
        if (root == null) {
            return maxVal - minVal;
        }
        minVal = Math.min(minVal, root.val);
        maxVal = Math.max(maxVal, root.val);
        let left = helper(root.left, minVal, maxVal);
        let right = helper(root.right, minVal, maxVal);
        return Math.max(left, right);
    }
};