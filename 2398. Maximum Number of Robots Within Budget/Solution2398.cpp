#include<iostream>
#include<vector>
#include<deque>

using namespace std;
class Solution2398 {
public:
    int maximumRobots(vector<int>& chargeTimes, vector<int>& runningCosts, long long budget) {
        int left = 0,  n = chargeTimes.size();
        long cursum = 0L;
        deque<int> d;
        for (int right = 0; right < n; right++) {
            cursum += runningCosts[right];
            while (!d.empty() && chargeTimes[d.back()] <= chargeTimes[right]) {
                d.pop_back();
            }
            d.push_back(right);
            if (chargeTimes[d.front()] + (right - left + 1) * cursum > budget) {
                if (d.front() == left) {
                    d.pop_front();
                }
                cursum -= runningCosts[left];
                left++;
            }
        }
        return n - left;
    }
};
