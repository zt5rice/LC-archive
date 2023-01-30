class Solution1137 {
public:
    int tribonacci(int n) {
        vector<long> dp{0,1,1};
        long cursum = 2;
        for (int i = 3; i <= n; i++) {
            int prev = dp[(i-3)%3];
            dp[i%3] = cursum;
            cursum = cursum * 2 - prev;
        }
        return (int)dp[n%3];
    }
    int tribonacci0(int n) {
        deque<int> dq;
        int sum = 0;
        if (n >= 0) {
            dq.push_back(0);
            sum += 0;
            if (n == 0) return 0;
        }
        if (n >= 1) {
            dq.push_back(1);
            sum += 1;
            if (n == 1) return 1;
        }
        if (n >= 2) {
            dq.push_back(1);
            sum += 1;
            if (n == 2) return 1;
        }
        for (int i = 3; i < n; i++) {
            dq.push_back(sum);
            int tmp = dq.front(); dq.pop_front();
            sum -= tmp;
            sum += dq.back();
        }
        return sum;
    }
};
// deque ref: http://c.biancheng.net/view/6860.html