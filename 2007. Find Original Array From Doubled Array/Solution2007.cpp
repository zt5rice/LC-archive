#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

class Solution2007 {
public:
    vector<int> findOriginalArray(vector<int>& changed) {
        if (changed.size() % 2 != 0) return {};
        int cmax = changed[0];
        for (int c : changed) {
            cmax = max(cmax, c);
        }
        vector<int> freq(cmax*2+1, 0);
        for (int c : changed) {
            freq[c]++;
        }
        vector<int> original;
        for (int num = 0; num <= cmax; num++) {
            if (freq[num]) {
                freq[num]--;
                int dnum = 2 * num;
                if (freq[dnum] > 0) {
                    freq[dnum]--;
                    original.push_back(num);
                    num--; //if multiple num exists
                } else {
                    return {};
                }
            }
        }
        return original;
    }
};