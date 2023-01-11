#include<string>
#include<vector>

using namespace std;

class Solution0205 {
public:
    bool isIsomorphic(string s, string t) {
        vector<int> stt(256,-1);        
        vector<int> tts(256,-1); 
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char cs = s[i], ct = t[i];
            if (stt[cs] == -1 && tts[ct] == -1) {
                stt[cs] = ct;
                tts[ct] = cs;
            } else if (stt[cs] != ct || tts[ct] != cs) {
                return false;
            }
        }
        return true;
    }
};