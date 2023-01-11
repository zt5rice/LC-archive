#include<iostream>
#include<vector>
#include<deque>

using namespace std;

class Solution0239 {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        deque<int> dq;
        vector<int> res;
        for (int i = 0; i < nums.size(); i++) {
            while (dq.size() && nums[dq.back()] <= nums[i]) {
                dq.pop_back();
            }
            while (dq.size() && dq.front() <= i - k) {
                dq.pop_front();
            }
            dq.push_back(i);
            if (i >= k - 1) {
                res.push_back(nums[dq.front()]);
            }
        }
        return res;
    }
};
