class Solution2259 {
public:
    string removeDigit(string number, char digit) {
        string res = "";
        for(int i=0; i<number.size(); i++){
            if(number[i] == digit){
                string temp = number.substr(0, i) + number.substr(i+1);
                res = max(res, temp);
            }
        }
        return res;
    }
};
https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/discuss/1996563/Easy-C%2B%2B