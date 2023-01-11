class Solution0316 {
public:
    string removeDuplicateLetters(string s) {
        vector<int> lastIdx(26,-1);
        vector<bool> inStack(26, false);
        stack<char> charStack;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            lastIdx[s[i] - 'a'] = i;
        }
        
        for (int i = 0; i < n; i++) {
            int curc = s[i] - 'a';
            if (inStack[curc]) continue;
            while (charStack.size()>0 && charStack.top() > s[i] && lastIdx[charStack.top()-'a'] > i) {
                inStack[charStack.top()-'a'] = false;
                charStack.pop();
            }
            charStack.push(s[i]);
            inStack[curc] = true;
        }
        
        string res = "";
        while (charStack.size()>0) {
            res = charStack.top() + res;
            charStack.pop();
        }
        return res;
    }
};
// https://leetcode.com/problems/remove-duplicate-letters/discuss/1859410/JavaC%2B%2B-DETAILED-%2B-VISUALLY-EXPLAINED-!!