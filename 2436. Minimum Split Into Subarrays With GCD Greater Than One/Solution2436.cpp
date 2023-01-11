
class Solution2436 {
public:
    int minimumSplits(vector<int>& nums) {
        int res = 1, gcd = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            gcd = getGcd(gcd, nums[i]);
            if (gcd == 1) {
                res++;
                gcd = nums[i];
            }
        }
        return res;
    }
    
    int getGcd(int a, int b) {
        return b == 0 ? a : getGcd(b, a%b);
    }
};