class Solution {
public:
    bool detectCapitalUse(string word) {
        int cap = 0;
        bool first = false;
        for (int i = 0; i < word.length(); i++) {
            if (i == 0 && isupper(word[i])) {
                first = true;
            }
            if (isupper(word[i])) {
                cap++;
            }
        }
        return (cap == 0 || cap == word.length() || (cap == 1 && first));       
    }
};