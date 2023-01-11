#include<iostream>
#include<vector>
#include<unordered_map>

using namespace std;

class Solution2244 {
public:
    int minimumRounds(vector<int>& tasks) {
        unordered_map<int, int> counter;
        for (int t : tasks) {
            counter[t]++;
        }
        int res = 0;
        for (auto& it : counter) {
            if (it.second == 1) return -1;
            res += (it.second + 2) / 3;
        }
        return res;
    }
};