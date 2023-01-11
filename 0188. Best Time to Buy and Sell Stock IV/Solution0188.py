import math

class Solution0188:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        n = len(prices)
        if n == 0: return 0
        k = min(k, n//2)
        
        buy = [-math.inf for _ in range(k+1)]        
        sell = [-math.inf for _ in range(k+1)]
        buy[0] = -prices[0]
        sell[0] = 0
        for i in range(1, n):
            buy[0] = max(buy[0], -prices[i]) #!!!!!!!!!!!! init
            for j in range(1, k+1):
                buy[j] = max(buy[j], sell[j]-prices[i])
                sell[j] = max(sell[j], buy[j-1]+prices[i])
        res = max(sell)
        return res

# https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/solution/si-wei-dao-tu-zheng-li-dpshu-zu-gou-jian-e97c/
class Solution0188_2:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        n = len(prices)
        if n < 2:
            return 0
        k = min(k, n//2)
        b,s = [-prices[0] for _ in range(k)],[0 for _ in range(k)]
        for i in range(1, n):
            b[0] = max(b[0], -prices[i])
            s[0] = max(s[0], b[0] + prices[i])
            for j in range(1,k):
                b[j] = max(b[j], s[j-1]-prices[i])
                s[j] = max(s[j], b[j] + prices[i])      
        return s[-1]