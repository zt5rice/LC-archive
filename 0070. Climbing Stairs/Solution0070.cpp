class Solution0070 {
public:
    int climbStairs(int n) {
        if (n < 2) return n;
        int pp = 1, p = 1, cur = 2;
        for (int i = 2; i <= n; i++) {
            cur = pp + p;
            pp = p; 
            p = cur;
        }
        return cur;
    }
};