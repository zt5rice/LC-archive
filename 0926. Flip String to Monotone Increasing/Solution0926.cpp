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

int main() {
    Solution0926 sol = Solution0926();
    string s = "00110";
    int res = sol.minFlipsMonoIncr(s);
    cout << res << endl;
}