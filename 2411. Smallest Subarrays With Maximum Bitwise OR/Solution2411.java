
class Solution2411 { 
    public int[] smallestSubarrays(int[] nums) {
        int[] last = new int[32];
        int n = nums.length;
        int[] res = new int[n];
        for (int i = n-1; i >= 0; i--) {
            res[i] = 1;
            for (int j = 0; j < 32; j++) {
                if ((nums[i] & (1 << j)) != 0) {
                    last[j] = i;
                }
                res[i] = Math.max(res[i], last[j] - i + 1);
            }
        }
        return res;
    }
}
// https://leetcode.com/problems/smallest-subarrays-with-maximum-bitwise-or/discuss/2588015/JavaC%2B%2BPython-Bit-Solution-with-Explanation