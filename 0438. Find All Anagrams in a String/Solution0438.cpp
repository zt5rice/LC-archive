class Solution0438 {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> sarr(26, 0); 
        vector<int> parr(26, 0); 
        int plen = p.length(), slen = s.length();
        vector<int> res;
        for (int i = 0; i < plen; i++) {
            parr[p[i] - 'a']++;
        }
        for (int i = 0; i < slen; i++) {
            if (i >= plen) {
                sarr[s[i-plen] - 'a']--;
            }
            sarr[s[i] - 'a']++;
            if (i >= plen - 1) {
                // if (arrequal(parr, sarr)) {
                if (parr == sarr) {
                    res.push_back(i-plen+1);
                }
            }
        }
        return res;
    }

    // bool arrequal(vector<int>& a1, vector<int>& a2) {
    //     for (int i = 0; i < 26; i++) {
    //         if (a1[i] != a2[i]) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
};