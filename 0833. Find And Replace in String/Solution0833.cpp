#include<iostream>
#include<string>
#include<vector>

using namespace std;

class Solution0833 {
public:
    string findReplaceString(string s, vector<int>& indices, vector<string>& sources, vector<string>& targets) {
        int n = s.length(), k = indices.size();
        vector<int> idx(n,-1);
        for (int i = 0; i < k; i++) {
            int srcStrStart = indices[i], srcStrLen = sources[i].length();
            string originStr = s.substr(srcStrStart, srcStrLen);
            if (originStr.compare(sources[i]) == 0) {
                idx[srcStrStart] = i;
            }
        }
        
        string res = "";
        for (int i = 0; i < n; i++) {
            if (idx[i] == -1) {
                res += s[i];
            } else {
                res += targets[idx[i]];
                i += (sources[idx[i]].length() - 1);
            }
        }
     
        return res;
    }
};