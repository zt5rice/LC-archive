#include <iostream>     // std::cout
#include <algorithm>    // std::upper_bound
#include <vector>       // std::vector
using namespace std;

class Solution0528 {
    vector<int> v;
public:
    Solution0528(vector<int>& w) {
        v.push_back(w[0]);
        for (int i = 1; i < w.size(); i++) {
            v.push_back(v[i-1]+w[i]);
        }
    }
    
    int pickIndex() {
        int n = rand() % v[v.size()-1];
        auto it = upper_bound(v.begin(), v.end(), n);
        return it - v.begin();
    }
};


// https://leetcode.com/problems/random-pick-with-weight/discuss/671632/C%2B%2B-simple-and-easy-solution-with-explanation
// http://c.biancheng.net/view/7527.html
// http://c.biancheng.net/view/7521.html