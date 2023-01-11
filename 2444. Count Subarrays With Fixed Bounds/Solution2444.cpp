class Solution2444 {
public:
    long long countSubarrays(vector<int>& nums, int minK, int maxK) {
        long res = 0, ibad = -1, imin = -1, imax = -1, n = nums.size();
        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || nums[i] > maxK) ibad = i;
            if (nums[i] == minK) imin = i;            
            if (nums[i] == maxK) imax = i;
            res += max(0L, min(imin, imax) - ibad);
        }
        return res;
    }
};