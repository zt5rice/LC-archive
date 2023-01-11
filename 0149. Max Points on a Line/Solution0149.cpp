#include<iostream>
#include<vector>
#include<string>
#include<map>

using namespace std;

class Solution0149 {
public:
    int maxPoints(vector<vector<int>>& points) {
        int maxpoint = 1;
        for (int i = 0; i < points.size(); i++) {
            map<string, int> slopemap;
            int curpoint = 0;
            for (int j = i+1; j < points.size(); j++) {
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                int k = gcd(dx, dy);
                string curkey = to_string(dx/k) + "_" + to_string(dy/k);
                slopemap[curkey] = slopemap[curkey] + 1;
                curpoint = max(curpoint, slopemap[curkey]);
            }
            maxpoint = max(curpoint+1, maxpoint);
        }
        return maxpoint;
    }
    
    int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x%y);
    }
};

// https://leetcode.cn/problems/max-points-on-a-line/solution/gong-shui-san-xie-liang-chong-mei-ju-zhi-u44s/