#include<iostream>
#include<vector>
#include<string>

using namespace std;

class Solution { // 16
public:
    vector<string> findMissingRanges(vector<int>& nums, int lower, int upper) {
        vector<string> res;
        int prev = lower-1, n = nums.size();
        for (int i = 0; i <= n; i++) {
            int cur = (i == n) ? upper+1 : nums[i];
            if (cur - 1 >= prev + 1) {
                res.push_back(getStr(prev+1, cur-1));
            }
            prev = cur;
        }
        return res;
    }
    
    string getStr(int left, int right) {
        if (left == right) {
            return to_string(left);
        }
        string res = to_string(left) + "->" + to_string(right);
        return res;
    }
};