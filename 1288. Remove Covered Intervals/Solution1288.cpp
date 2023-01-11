#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

class Solution1288 {
public:
    int removeCoveredIntervals(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), [](const vector<int>& u, const vector<int>& v) {
            return u[0] < v[0] || (u[0] == v[0] && u[1] > v[1]);
        });
        int len = intervals.size();
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (intervals[i][1] > end) {
                end = intervals[i][1];
                count++;
            }
        }
        return count;
    }
};

// 作者：LeetCode-Solution
// 链接：https://leetcode.cn/problems/remove-covered-intervals/solution/shan-chu-bei-fu-gai-qu-jian-by-leetcode-solution/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。