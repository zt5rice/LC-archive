public class Solution2366 {
    public long minimumReplacement(int[] nums) {
        long count = 0;
        int n = (int) nums.length, prev = (int) 1e9;
        for (int i = n - 1; i >= 0; i--) {
            int k = (nums[i] - 1 + prev) / prev; // times of operations
            count += (long) k - 1;
            prev = nums[i] / k;
        }
        return count;
    }
}
// ref https://leetcode.com/problems/minimum-replacements-to-sort-the-array/discuss/2388265/JavaC%2B%2BPython-One-Reverse-Pass