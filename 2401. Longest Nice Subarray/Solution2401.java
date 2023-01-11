public class Solution2401 {
    public int longestNiceSubarray(int[] nums) {
        int maxLen = 0, n = nums.length;
        int left = 0, curMask = 0;
        for (int right = 0; right < n; right++) {
            while ((curMask & nums[right]) > 0) {
                curMask ^= nums[left++];
            }
            curMask |= nums[right];
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }    
}

// https://leetcode.cn/problems/longest-nice-subarray/solution/bao-li-mei-ju-pythonjavacgo-by-endlessch-z6t6/