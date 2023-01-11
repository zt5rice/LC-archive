#include<iostream>
#include<vector>
#include<string>

using namespace std;

class Solution0944 {
public:
    int minDeletionSize(vector<string>& strs) {
        int row = strs.size(), col = strs[0].length();
        int res = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 1; j < row; j++) {
                if (strs[j][i] < strs[j-1][i]) {
                    res++;
                    break;
                }
            }
        }
        return res;        
    }
};

int main() {
    vector<string> strs{"cba","daf","ghi"};
    Solution0944 sol = Solution0944();
    int res = sol.minDeletionSize(strs);
    cout << res << endl;
    return -1;
}