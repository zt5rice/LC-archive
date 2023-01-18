public class Solution0918 {
    public int maxSubarraySumCircular(int[] A) {
          int total = 0, maxSum = A[0], curMax = 0, minSum = A[0], curMin = 0;
          for (int a : A) {
              curMax = Math.max(curMax + a, a);
              maxSum = Math.max(maxSum, curMax);
              curMin = Math.min(curMin + a, a);
              minSum = Math.min(minSum, curMin);
              total += a;
          }
          return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
          // return Math.max(maxSum?, total - minSum);
          // [-3,-2,-3] 如果全是负数，那么maxSum就会是负数，总和total就会等于最小和minSum。不这么判断的话，返回值就会是0，实际应该直接返回maxSum  
      }
  
  // 作者：xing-you-ji
  // 链接：https://leetcode.cn/problems/maximum-sum-circular-subarray/solution/wo-hua-yi-bian-jiu-kan-dong-de-ti-jie-ni-892u/
  // 来源：力扣（LeetCode）
  // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}