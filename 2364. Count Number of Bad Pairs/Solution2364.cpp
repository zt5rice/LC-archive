#include<iostream>
#include<map>
#include<vector>

using namespace std;

class Solution2364 {
public:
    long long countBadPairs(vector<int>& nums) {
        map<int, long> count;
        long res = 0L;
        long n = (long) nums.size();
        for (int i = 0; i < n; i++) {
            int dif = nums[i] - i;
            res += count[dif]++;
            // count[dif]++;
        }
        return n*(n-1) / 2 - res;
    }
};