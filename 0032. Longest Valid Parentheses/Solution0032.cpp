class Solution0032 {
public:
    int longestValidParentheses(string s) {
        int left = 0, right = 0, maxLen = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (s[i] == '(') {
                left++;
            } else if (s[i] == ')') {
                right++;
            }
            if (left == right) {
                maxLen = max(maxLen, right * 2);
            } else if (right > left) {
                left = 0; right = 0;
            }
        }
        left = 0; right = 0;
        for (int i = n-1; i >= 0; i--) { // ()(()
            if (s[i] == '(') {
                left++;
            } else if (s[i] == ')') {
                right++;
            }
            if (left == right) {
                maxLen = max(maxLen, left * 2);
            } else if (right < left) {
                left = 0; right = 0;
            }
        }
        return maxLen;
    }
};

class Solution0032_1 {
public:
    int longestValidParentheses(string s) {
        int maxLen = 0;
        stack<int> stk;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s[i] == '(') {
                stk.push(i);
            } else {
                if (!stk.empty() && s[stk.top()] == '(') {
                    stk.pop();                
                    int left = stk.empty()? -1 : stk.top();
                    maxLen = max(maxLen, i - left);
                } else {
                    stk.push(i);
                }
            }
        }
        return maxLen;
    }
};