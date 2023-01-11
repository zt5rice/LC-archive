#include<iostream>
#include<string>
#include<vector>
#include<map>
#include<algorithm>
#include<unordered_map>

using namespace std;

class Solution1048 {
    static bool compare(string& w1, string& w2) {
        return w1.length() < w2.length();
    }
public:
    int longestStrChain(vector<string>& words) {
        sort(words.begin(), words.end(), compare);
        int longest = 1;
        unordered_map<string, int> lengthMap;
        for (string word : words) {
            for (int i = 0; i < word.length(); i++) {
                string pre = word.substr(0,i) + word.substr(i+1);
                lengthMap[word] = max(lengthMap[word], lengthMap.find(pre) == lengthMap.end() ? 1 : lengthMap[pre] + 1);
            }
            longest = max(longest, lengthMap[word]);
        }
        
        return longest;
    }
};
https://leetcode.com/problems/longest-string-chain/discuss/294890/JavaC%2B%2BPython-DP-Solution