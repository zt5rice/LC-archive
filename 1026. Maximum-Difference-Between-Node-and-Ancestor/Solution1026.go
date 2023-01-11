import "math"

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func maxAncestorDiff(root *TreeNode) int {
	return helper(root, root.Val, root.Val)
}

func helper(root *TreeNode, minVal int, maxVal int) int {
	if root == nil {
		return maxVal - minVal
	}
	var left, right int
	minVal = int(math.Min(float64(minVal), float64(root.Val)))
	maxVal = int(math.Max(float64(maxVal), float64(root.Val)))
	left = helper(root.Left, minVal, maxVal)
	right = helper(root.Right, minVal, maxVal)
	return int(math.Max(float64(left), float64(right)))
}