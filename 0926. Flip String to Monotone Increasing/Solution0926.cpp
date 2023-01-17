#include<iostream>
#include<string>
#include<algorithm>

using namespace std;

class Solution0926 {
public:
    int minFlipsMonoIncr(string s) {
        int res = 0, ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == '1') {
                ones++;
            } else {
                res = min(res + 1, ones);
            }
        }
        return res;
    }
};