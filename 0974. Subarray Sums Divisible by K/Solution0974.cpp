class Solution0974 {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        vector<int> rem(k, 0);
        rem[0] = 1;
        int curSum = 0, count = 0, curRem = 0;
        for (int i = 0; i < nums.size(); i++) {
            curSum += nums[i];
            if (curSum % k >= 0) {
                curRem = curSum % k;
            } else {
                curRem = curSum % k + k;
            }
            count += rem[curRem];
            rem[curRem]++;
        }
        return count;
    }
};