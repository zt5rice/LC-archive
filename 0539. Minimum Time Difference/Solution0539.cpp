#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

class Solution0539 { // 18 - 24
public:
    int findMinDifference(vector<string>& timePoints) {
        int n = timePoints.size();
        vector<int> times(n,0);
        for (int i = 0; i < n; i++) {
            times[i] = convTime(timePoints[i]);
        }
        sort(times.begin(), times.end());
        int res = 24*60+1;
        for (int i = 1; i < n; i++) {
            res = min(times[i]-times[i-1], res);
        }
        res = min(res, times[n-1]-times[0]);        
        res = min(res, times[0]+24*60-times[n-1]);
        return res;
    }
    
    int convTime(string timePoint) {
        int hr = stoi(timePoint.substr(0,2));        
        int min = stoi(timePoint.substr(3));
        return hr * 60 + min;
    }
};