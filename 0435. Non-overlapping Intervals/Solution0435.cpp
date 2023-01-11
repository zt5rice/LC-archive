
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

class Solution0435 {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), [](vector<int>& i1, vector<int>& i2) {
            return i1[1] < i2[1];
        });
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }
        return intervals.size() - count;
    }
};