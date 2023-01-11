class Solution {
public:
    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
        vector<vector<int>> res;
        vector<pair<int, int>> height;
        for (auto &b : buildings) {
            // 正负用于判别是左端点还是右端点，同时保证排序后：
            // 左端点相同时，最高的楼排在前面，insert的一定是相同左端点中最大的高度
            // 右端点相同时，最低的楼排在前面，erase的时候不会改变最大高度
            height.push_back({b[0], -b[2]}); // 左端点
            height.push_back({b[1], b[2]});  // 右端点
        }
        sort(height.begin(), height.end());
        // 维护当前最大高度
        multiset<int> st;
        st.insert(0); // 保证端点全部删除之后能得到当前最大高度为 0
        // preMaxHeight 表示遇到一个端点之前的最大高度
        // curMaxHeight 表示遇到一个端点之后的当前最大高度
        int preMaxHeight = 0, curMaxHeight = 0;
        for (auto &h : height) {
            if (h.second < 0) { // 左端点
                st.insert(-h.second);
            } else { // 右端点
                st.erase(st.find(h.second));
            }
            
            curMaxHeight = *st.rbegin();
            // 最大高度发生改变，一定是一个 key point，即一个水平线段的左端点
            if (curMaxHeight != preMaxHeight) {
                res.push_back({h.first, curMaxHeight});
                preMaxHeight = curMaxHeight;
            }
        }
        return res;
    }
};

// 作者：mfk443838746
// 链接：https://leetcode.cn/problems/the-skyline-problem/solution/tian-ji-xian-gen-ju-zuo-you-bian-jie-pai-apj3/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。