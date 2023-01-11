#include<vector>
#include<algorithm>

using namespace std;

class Solution0948 {
public:
    int bagOfTokensScore(vector<int>& tokens, int power) {
        int point = 0, res = 0;
        sort(tokens.begin(), tokens.end());
        int left = 0, n = tokens.size(), right = n - 1;
   
        while (left <= right && (power >= tokens[left] || point > 0)) {
            while (left <= right && power >= tokens[left]) {
                point++;
                power -= tokens[left++];
            }
            res = max(point, res);
            if (left <= right && point > 0) {
                point--;
                power += tokens[right--];
            }
        }
        
        return res;        
    }
};

