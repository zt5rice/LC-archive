#include<iostream>
#include<vector>
#include<string>
#include<string>
#include<stack>
#include<vector>
#include<unordered_set>
#include<unordered_map>
#include<functional>
#include<assert.h>

using namespace std;

class Solution0150 {
public:
    int evalRPN(vector<string>& tokens) {
        unordered_set<string> ops = {"+","-","*","/"};
        stack<long> st;

        for (auto s : tokens) {
            if (ops.find(s) == ops.end()) {
                st.push(stoi(s));
            } else {
                long num2 = st.top(); st.pop();
                long num1 = st.top(); st.pop();
                if (s == "+") st.push(num1 + num2);
                if (s == "-") st.push(num1 - num2);
                if (s == "*") st.push(num1 * num2);
                if (s == "/") st.push(num1 / num2);
            }
        }
        return st.top();
    }
    int evalRPNfancy(vector<string>& tokens) {
        stack<int> s;
        unordered_map<string, function<int(int,int)>> map {
            { "+", std::plus<int>() },
            { "-", std::minus<int>() },
            { "*", std::multiplies<int>() },
            { "/", std::divides<int>() }
        };
        
        for (const auto& token : tokens) {
            const auto& op = map.find(token);
            if (op != map.end()) {
                assert(s.size() >= 2);
                int rhs = s.top(); s.pop();
                int lhs = s.top(); s.pop();
                s.push((*op).second(lhs, rhs));
            } else {
                s.push(stoi(token));
            }
        }
        
        assert(s.size() == 1);
        return s.top();
    }
};

int main() {
    vector<string> tokens{"2","1","+","3","*"};
    Solution0150 sol;
    int res = sol.evalRPN(tokens);
    cout << res << endl;
    int res2 = sol.evalRPN(tokens);
    cout << res2 << endl;
    return 0;
}