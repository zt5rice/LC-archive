#include<iostream>
#include<vector>
#include<string>
#include<unordered_map>

using namespace std;

class Solution9553 {
public:
    bool isAlienSorted(vector<string>& words, string order) {
        unordered_map<char, int> ordDict;
        for (int i = 0; i < order.length(); i++) {
            ordDict[order[i]] = i;
        }
        for (int i = 0; i < words.size()-1; i++) {
            if (!check(ordDict, words[i], words[i+1])) {
                return false;
            }
        }
        return true;
    }

    bool check(unordered_map<char, int>& wordDict, string w1, string w2) {
        int limsize = min(w1.length(), w2.length());
        for (int i = 0; i < limsize; i++) {
            if (w1[i] != w2[i]) {
                if (wordDict[w1[i]] > wordDict[w2[i]]) {
                    return false;
                } else {
                    return true;
                }
            } 
        }
        if (w1.length() > w2.length()) return false; //!!!
        return true;
    }
};