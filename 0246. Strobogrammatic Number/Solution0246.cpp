class Solution0246 {
public:
    bool isStrobogrammatic(string num) {
        unordered_map<char, char> m{{'0','0'}, {'1','1'}, {'6','9'}, {'8','8'}, {'9','6'}};
        int left = 0, right = num.length() - 1;
        while (left <= right) {
            if (m[num[left++]] != num[right--]) return false;
        }
        return true;        
    }
};