class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, n = nums.length;
        // [left, right)
        int longest = 0, curLen = 0;
        for (right = 0; right < n; right++) {
            if (nums[right] == 0) {
                k--;
            }
            if (k >= 0) {
                longest = Math.max(longest, right - left + 1);
            }
            while (k < 0 && left < right) {
                if (nums[left++] == 0) {
                    k++;
                }
            }
        }
        return longest;
    }
}