#include<vector>
using namespace std;
class Solution0119 {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> res(1,1);
        for (int i = 0; i < rowIndex; i++) {
            res.push_back((int) (res[i] * (long long)(rowIndex-i) / (i+1)));
        }
        return res;
    }
};