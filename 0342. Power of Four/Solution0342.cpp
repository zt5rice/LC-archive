class Solution0342 {
public:
    bool isPowerOfFour(int num) {
         return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);
    }
};