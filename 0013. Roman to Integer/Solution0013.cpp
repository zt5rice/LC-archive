#include <iostream>
#include <string>
#include <map>

using namespace std;

class Solution0013 {
public:
    int romanToInt(string s) {
        map<char, int> m{{'I', 1}, {'V', 5}, 
                     {'X', 10}, {'L', 50},
                     {'C', 100}, {'D', 500},
                     {'M', 1000}};
        int res = 0; 
        for (int i = 0; i < s.length(); i++) {
            res += m[s[i]];
            if (i > 0 && m[s[i-1]] < m[s[i]]) {
                res -= 2 * m[s[i-1]];
            }
        }
        return res;
    }
};

int main() {
    Solution0013 sol;
    
    string s1 = "III";
    int i1 = sol.romanToInt(s1);
    cout << s1 << ": " << i1 << endl;
    string s2 = "LVIII";
    int i2 = sol.romanToInt(s2);
    cout << s2 << ": " << i2 << endl;
    string s3 = "MCMXCIV";
    int i3 = sol.romanToInt(s3);
    cout << s3 << ": " << i3 << endl;
    return -1;
}