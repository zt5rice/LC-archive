#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

class Solution1871 {
public:
    bool canReach(string s, int minJump, int maxJump) {
        int n = s.length();
        vector<bool> dp(n, false);
        dp[0] = true;
        int cnt = 1;
        for (int i = minJump; i < n; i++) {
            if (s[i] == '0' && cnt > 0) {
                dp[i] = true;
            }
            // left
            if (i>=maxJump && dp[i-maxJump]) {
                cnt--;
            }
            if (dp[i-minJump+1]) {
                cnt++;
            }
        }
        return dp[n-1];
    }
};

// 作者：baizimiao
// 链接：https://leetcode.cn/problems/jump-game-vii/solution/hua-chuang-si-xiang-dp-bu-xu-yao-qian-zh-j865/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。