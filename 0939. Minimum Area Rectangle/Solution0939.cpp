class Solution {
public:
    int minAreaRect(vector<vector<int>>& points) {
        set<pair<int, int>> pts;
        for (vector<int> point : points) {
            pts.insert({point[0], point[1]});
        }
        int res = INT_MAX;
        for (int i = 0; i < points.size(); i++) {
            for (int j = i+1; j < points.size(); j++) {
                if (points[i][0] == points[j][0] || points[i][1] == points[j][1]) {
                    continue;
                }
                if (pts.count({points[i][0], points[j][1]}) && pts.count({points[j][0], points[i][1]}) ) {
                    res = min(res, abs(points[i][0] - points[j][0]) * abs(points[i][1] - points[j][1]));
                }
            }
        }
        return res == INT_MAX ? 0 : res;
    }
};