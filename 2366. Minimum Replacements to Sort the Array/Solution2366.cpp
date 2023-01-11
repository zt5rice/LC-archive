#include<vector>

using namespace std;

class Solution2366 {
public:
    long long minimumReplacement(vector<int>& nums) {
        long count = 0L;
        int n = nums.size(), prev = (int) 1e9, k = 0;
        for (int i = n - 1; i >= 0; i--) {
            k = (nums[i] + prev - 1) / prev;
            prev = nums[i] / k;
            count += (long) k - 1;
        }
        return count;
    }
};
// ref https://leetcode.com/problems/minimum-replacements-to-sort-the-array/discuss/2388265/JavaC%2B%2BPython-One-Reverse-Pass